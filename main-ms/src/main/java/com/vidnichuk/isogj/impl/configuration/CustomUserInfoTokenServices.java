package com.vidnichuk.isogj.impl.configuration;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.*;


/**
 * Class that overrides UserInfoTokenServices from Spring Boot. It corrects scopes and clientId retrieve.
 */
public class CustomUserInfoTokenServices extends UserInfoTokenServices {

    /**
     * Override constructor because UserInfoTokenServices doesn't have default constructor.
     */
    public CustomUserInfoTokenServices(String userInfoEndpointUrl, String clientId) {
        super(userInfoEndpointUrl, clientId);
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken)
            throws AuthenticationException, InvalidTokenException {
        OAuth2Authentication auth2Authentication = super.loadAuthentication(accessToken);
        Authentication userAuthentication = auth2Authentication.getUserAuthentication();

        @SuppressWarnings("unchecked")
        Set<String> scopes = extractScopes((Map<String, Object>) userAuthentication.getDetails());
        @SuppressWarnings("unchecked")
        String clientId = extractClientId((Map<String, Object>) userAuthentication.getDetails());
        OAuth2Request request = new OAuth2Request(null, clientId,
                null, true, scopes,
                null, null, null, null);


        return new OAuth2Authentication(request, userAuthentication);
    }

    /**
     * Extracting scopes of request
     *
     * @param map of request details
     * @return set of scopes
     */
    @SuppressWarnings("unchecked")
    private Set<String> extractScopes(Map<String, Object> map) {
        if (map != null) {
            Map<String, Object> oauth2Request = (Map<String, Object>) map.get("oauth2Request");
            if (oauth2Request != null) {
                Object scope = oauth2Request.get("scope");
                if (scope instanceof Collection) {
                    return new HashSet<>((Collection<String>) scope);
                }
            }
        }

        return Collections.emptySet();
    }

    /**
     * Extracting clientId of request.
     *
     * @param map
     * @return
     */
    @SuppressWarnings("unchecked")
    private String extractClientId(Map<String, Object> map) {
        if (map != null) {
            Map<String, Object> oauth2Request = (Map<String, Object>) map.get("oauth2Request");
            if (oauth2Request != null) {
                Object clientId = oauth2Request.get("clientId");
                if (clientId instanceof String) {
                    return (String) clientId;
                }
            }
        }

        return "unknown-client";
    }

}
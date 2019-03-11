package com.vidnichuk.isogj.impl.config;

import com.vidnichuk.isogj.api.service.UserService;
import com.vidnichuk.isogj.impl.config.properties.AuthProperties;
import com.vidnichuk.isogj.impl.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthProperties authProperties;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("api")
                .and()

                .withClient("oauth-ms")
                .secret(authProperties.getPasswords().getOauthMs())
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .and()

                .withClient("main-ms")
                .secret(authProperties.getPasswords().getMainMs())
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .and()

                .withClient("gateway-ms")
                .secret(authProperties.getPasswords().getGatewayMs())
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server");

    }
    

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .userDetailsService(username -> userService.loadUserByUsername(username))
                .reuseRefreshTokens(false)
                .authenticationManager(authenticationManager);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Bean
    public InMemoryTokenStore tokenStore() {
        return new InMemoryTokenStore();
    }



}

package com.vidnichuk.isogj.impl.config.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.vidnichuk.isogj.auth")
public class AuthProperties {

    @NestedConfigurationProperty
    private Passwords passwords;

    public Passwords getPasswords() {
        return passwords;
    }

    public void setPasswords(Passwords passwords) {
        this.passwords = passwords;
    }

    public static class Passwords {
        private String mainMs;
        private String gatewayMs;
        private String oauthMs;

        public String getMainMs() {
            return mainMs;
        }

        public void setMainMs(String mainMs) {
            this.mainMs = mainMs;
        }

        public String getGatewayMs() {
            return gatewayMs;
        }

        public void setGatewayMs(String gatewayMs) {
            this.gatewayMs = gatewayMs;
        }

        public String getOauthMs() {
            return oauthMs;
        }

        public void setOauthMs(String oauthMs) {
            this.oauthMs = oauthMs;
        }
    }
}

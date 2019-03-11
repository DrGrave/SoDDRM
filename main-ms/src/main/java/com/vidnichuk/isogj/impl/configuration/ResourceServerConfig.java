package com.vidnichuk.isogj.impl.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private UserInfoRestTemplateFactory restTemplateFactory;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/v2/api-docs",
                        "/webjars/**").permitAll()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/user/checklogin").permitAll()
                .antMatchers("/user/checkemail").permitAll()
                .antMatchers("/user/confirm**").permitAll()
                .anyRequest().authenticated()
        ;


    }

    /**
     * @return user info token services bean
     */
    @Bean
    ResourceServerTokenServices userInfoTokenServices(ResourceServerProperties sso) {
        CustomUserInfoTokenServices tokenServices = new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
        tokenServices.setRestTemplate(restTemplateFactory.getUserInfoRestTemplate());
        return tokenServices;
    }

}

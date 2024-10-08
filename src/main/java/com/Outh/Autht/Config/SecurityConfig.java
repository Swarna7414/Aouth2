package com.Outh.Autht.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
         httpSecurity.authorizeHttpRequests(auth->{
            auth.requestMatchers("/h2-console/**").permitAll().
            requestMatchers("/").permitAll();
            auth.anyRequest().authenticated();
        });
         httpSecurity.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.headers(headers->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        httpSecurity.csrf(csrf->csrf.disable())
        .oauth2Login(Customizer.withDefaults());

        return httpSecurity.build();
    }
}

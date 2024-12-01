package com.example.demo.employeemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // Enables @PreAuthorize and similar annotations
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/employees/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/departments/**").hasRole("ADMIN")
                        .requestMatchers("/projects/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/", "/login**").permitAll()
                        .anyRequest().authenticated()
                )
                .apply(new OAuth2LoginConfigurer<>());

        return http.build();
    }
}
package com.financeplanner;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permit all requests
            )
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection
            .formLogin(form -> form.disable()); // Disable the default login form

        return http.build();
    }
}
package com.project.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.server.WebFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())   // Disable CSRF since we use JWT
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/auth/**").permitAll();  // Permit all requests to the /auth path
                    auth.anyRequest().authenticated();  // All other requests need to be authenticated
                })
                .addFilterBefore(jwtAuthenticationFilter, SecurityFilterChain.class) // Add JWT filter
                .build();
    }
}

package com.microservices_api_gateway.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class GatewaySecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(csrf -> csrf.disable())          // Disable CSRF
                .authorizeExchange(exchange -> exchange
                        .anyExchange().permitAll()          // Allow all requests without authentication
                )
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable);  // Disable HTTP Basic auth

        return http.build();
    }
}

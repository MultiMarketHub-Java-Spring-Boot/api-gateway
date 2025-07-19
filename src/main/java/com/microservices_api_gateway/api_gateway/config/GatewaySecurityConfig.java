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
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)  // ✅ IMPORTANT: disable browser popup
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(
                                "/auth-service/user/login",
                                "/user-service/admin/userLogin",
                                "/user-service/hello",
                                "/auth-service/extract-username",
                                "/product-service/listProducts",
                                "/store-service/stores"
                        ).permitAll()
                        .pathMatchers("/user-service/admins").permitAll()
                );
        return http.build();
    }
}

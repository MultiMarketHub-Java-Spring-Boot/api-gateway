package com.microservices_api_gateway.api_gateway.filters;

import com.microservices_api_gateway.api_gateway.Clients.AuthServiceClient;
import jakarta.servlet.ServletException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final AuthServiceClient authServiceClient;

    public JwtAuthFilter(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token =null;
        String username = null;
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token  = authHeader.substring(7);
            username = authServiceClient.extractUsername(token);
            System.out.println(username);
        }
        filterChain.doFilter(request, response);
//       Validate Token
        return;
    }
}

package com.microservices_api_gateway.api_gateway.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "auth-service") // 💡 Must match the application name in Auth Service's application.yml
public interface AuthServiceClient {

    @GetMapping("/extract-username")
    String extractUsername(@RequestHeader("token") String token);
}

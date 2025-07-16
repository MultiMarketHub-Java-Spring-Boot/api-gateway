package com.microservices_api_gateway.api_gateway;
import jakarta.annotation.PostConstruct;
//import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.util.ClassUtils;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@PostConstruct
	public void logWebStack() {
		System.out.println("🟢 Running in WebFlux mode: " +
				ClassUtils.isPresent("org.springframework.web.reactive.DispatcherHandler", null));
	}
}


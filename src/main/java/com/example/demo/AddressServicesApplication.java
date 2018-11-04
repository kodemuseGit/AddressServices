package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RefreshScope
@ComponentScan(basePackages={"com.example.demo.config", "com.example.demo.services", "com.example.demo"})
public class AddressServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServicesApplication.class, args);
	}
}

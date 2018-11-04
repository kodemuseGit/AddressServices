package com.example.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@RibbonClient(name="ribbon-client")
public class RestClientConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		System.out.println("creating... rest");
		return new RestTemplate();
	}
}

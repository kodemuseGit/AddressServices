package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class RestClient {

	private static RestClient instance = new RestClient();
	@Autowired
	private RestTemplate restTemplate;

	private RestClient() {
	}

	public static RestClient getInstance() {
		return instance;
	}

	public RestTemplate getRestTemplate() {
		System.out.println("Rest template >> " + restTemplate);
		return restTemplate;
	}

}

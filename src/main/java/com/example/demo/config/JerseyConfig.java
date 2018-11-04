package com.example.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.demo.services.AddressService;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		registerEndPoints();
	}

	private void registerEndPoints() {
		register(AddressService.class);
	}

}

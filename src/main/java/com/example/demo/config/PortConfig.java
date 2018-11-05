package com.example.demo.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SocketUtils;

@Configuration
public class PortConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	private final int MIN_PORT = 2000;
	private final int MAX_PORT = 2100;

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		factory.setPort(getAvailablePort());
	}

	private int getAvailablePort() {
		return SocketUtils.findAvailableTcpPort(MIN_PORT, MAX_PORT);

	}

}

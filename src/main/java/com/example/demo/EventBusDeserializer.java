package com.example.demo;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EventBusDeserializer implements Deserializer<EventBus> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public EventBus deserialize(String topic, byte[] data) {
		System.out.println("=======================1 : " + topic);
		EventBus eventBus = null;
		if (topic.equals("test-demo")) {
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				eventBus = mapper.readValue(data, EventBus.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return eventBus;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}

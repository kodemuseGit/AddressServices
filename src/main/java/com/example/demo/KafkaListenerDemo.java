package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerDemo {

	@Autowired
	private KafkaSender kafkaSender;

	@KafkaListener(topics = "test-demo", groupId = "test-demo")
	public void receiveTopic1(ConsumerRecord<?, ?> consumerRecord) {
		System.out.println("Receiver on topic1: " + consumerRecord.toString());
		System.out.println("Value :" + consumerRecord.value());
		EventBus eventBus = (EventBus) consumerRecord.value();
		System.out.println("Event Bus : " + eventBus.toString());
		kafkaSender.send("customer", "Address updated successfully!");
	}
}

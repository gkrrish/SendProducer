package com.sendproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sendproducer.util.SenderKafkaUTIL;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;


	public void sendMessage(String givenMessage) {
		kafkaTemplate.send(SenderKafkaUTIL.TOPIC, givenMessage);
	}

}

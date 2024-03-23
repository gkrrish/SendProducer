package com.sendproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sendproducer.service.KafkaConnectionCheckerService;
import com.sendproducer.service.KafkaProducerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "MessageContoller", description = "Message Controller APIs")
@RestController
public class MessageController {

	@Autowired
	private KafkaProducerService kafkaProducer;

	@Autowired
	KafkaConnectionCheckerService kafkaConnectionChecker;
	
	@ResponseStatus
	@PostMapping("/send")
	@Operation(summary = "sendKafka", description = "send A message to Kafka")
	public String sendKafka(@RequestBody String message) {
		kafkaProducer.sendMessage(message);
		return "Message sent to Kafka topic successfully!";
	}
	@ResponseStatus
	@GetMapping("/connection")
	@Operation(summary = "checkKafkaConnection", description = "check Kafka connection")
	public String checkKafkaConnection() {
		boolean isConnected = kafkaConnectionChecker.checkConnection();
		return isConnected ? "Connection to Kafka is successful" : "Failed to connect to Kafka";

	}

}

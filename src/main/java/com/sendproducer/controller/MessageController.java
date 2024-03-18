package com.sendproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sendproducer.service.KafkaProducerService;

@RestController
public class MessageController {
	
	@Autowired
    private KafkaProducerService kafkaProducer;
	
	@PostMapping("/send")
    public String sendKafka(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return "Message sent to Kafka topic successfully!";
    }
	
	@GetMapping("/test")
	public String test() {
		return "hello";
	}

}

package com.sendproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sendproducer"})
public class SendProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendProducerApplication.class, args);
	}

}

package com.sendproducer.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Properties;

@Service
public class KafkaConnectionCheckerService {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConnectionCheckerService.class);

	private static final String BOOTSTRAP_SERVERS = "localhost:9092";

	public boolean checkConnection() {
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

		try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
			producer.send(new ProducerRecord<>("test-topic", "test-message")).get();

			return true;

		} catch (Exception e) {
			logger.error("Failed to check connection to Kafka", e);
			return false;
		}
	}
}

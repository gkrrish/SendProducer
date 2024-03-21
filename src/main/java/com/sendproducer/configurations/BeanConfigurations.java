package com.sendproducer.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class BeanConfigurations {

	@Value("${spring.kafka.producer.topic}")
	private String topicName;

	@Bean
	NewTopic topic() {
		return TopicBuilder.name(topicName)
				.partitions(10)
				.replicas(2)
				.build();
	}

}

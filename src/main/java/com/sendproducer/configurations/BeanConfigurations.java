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
	    NewTopic topic() {//for this topic we are adding some configurations, hence created the bean
	        return TopicBuilder.name(topicName)//topic name
	                .partitions(10)//in high sub lines we call partitions
	                .replicas(1)//fault tolerance
	                .build();
	    }

}

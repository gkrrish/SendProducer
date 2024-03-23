package com.sendproducer.configurations;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("*").pathsToMatch("/**").build();
    }

    @Bean
    OpenAPI openApiInfo() {
        return new OpenAPI()
                .info(new Info().title("Spring Kafka Test")
                .description("An example about Spring Kafka and testing producer and consumer")
                .version("v0.0.1")
                .license(new License()));
    }

}

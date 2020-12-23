package com.example.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller","com.example.food","com.example.service","com.example.repository","com.example.model"})

@EnableJpaRepositories(basePackages = {"com.example.repository"})
@EntityScan(basePackages = {"com.example.model"})
public class EasyFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyFoodApplication.class, args);
	}

}

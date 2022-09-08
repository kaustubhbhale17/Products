package com.example.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceApplication {

	//get Products by userId
	//userService    -> 3301
	//productService -> 3002
	public static void main(String[] args) {

		SpringApplication.run(ProductServiceApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate(){

		return new RestTemplate();
	}

}

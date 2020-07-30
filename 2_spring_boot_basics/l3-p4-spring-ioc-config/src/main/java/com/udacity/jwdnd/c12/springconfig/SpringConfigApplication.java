package com.udacity.jwdnd.c12.springconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class SpringConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigApplication.class, args);
	}

	/*@Bean
	public String basicMessage() {
		System.out.println("inside basicMessage");
		return "Hello";
	}

	@Bean
	public String compoundMessage(String basicMessage) {
		System.out.println("insider compoundMessage, received: " + basicMessage);
		return basicMessage + ", Spring!";
	}*/
}

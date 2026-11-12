package com.spring.spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot REST application.
 */
@SpringBootApplication
public class SpringRestApplication {

	/**
   * Starts the Spring Boot application.
   *
   * @param args command-line arguments passed at startup
   */
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}

package com.spring.spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring REST application.
 * This class initializes and launches the Spring Boot application context,
 * enabling auto-configuration and component scanning within the
 * {@code com.spring.spring_rest} package.
 */
@SpringBootApplication
public class SpringRestApplication {

	/**
	 * Starts the Spring Boot application.
	 *
	 * @param args command-line arguments passed during application startup
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}

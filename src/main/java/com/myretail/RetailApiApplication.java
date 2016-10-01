package com.myretail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetailApiApplication {
	private final static  Logger logger = LoggerFactory.getLogger(RetailApiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RetailApiApplication.class, args);
		logger.info("Application Started Successfully");
	}
}

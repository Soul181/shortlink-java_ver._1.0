package com.example.shortlink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


@SpringBootApplication
public class ShortlinkApplication {
	private static final Logger logger = LogManager.getLogger(ShortlinkApplication.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j2.properties");
		logger.info("Start ShortlinkApplication NOW");
		SpringApplication.run(ShortlinkApplication.class, args);
	}
}

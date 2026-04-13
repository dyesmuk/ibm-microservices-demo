package com.ibm.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class App {
	
	private final static Logger LOG = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		LOG.info("Starting...");
		SpringApplication.run(App.class, args);
		LOG.info("Started.");
	}
	
}

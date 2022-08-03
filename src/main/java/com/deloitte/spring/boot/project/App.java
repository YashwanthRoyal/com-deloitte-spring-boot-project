package com.deloitte.spring.boot.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);


	public static void main(String[] args) {
		
		App.log.info("Start");
		SpringApplication.run(App.class, args);
		App.log.info("End");
		
	}

}

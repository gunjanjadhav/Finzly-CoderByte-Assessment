package com.FXTrading SpringBoot Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FxTradingApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(FxTradingApplication.class, args);
		
		System.out.println("Application Started");
	}

}

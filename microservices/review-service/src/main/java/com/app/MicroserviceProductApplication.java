package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.app.api.MicroserviceProductApplication.class, args);
	}

}

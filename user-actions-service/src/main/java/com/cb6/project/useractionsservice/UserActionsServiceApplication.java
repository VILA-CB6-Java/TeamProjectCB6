package com.cb6.project.useractionsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserActionsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserActionsServiceApplication.class, args);
	}

}


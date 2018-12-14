package com.cb6.project.adminannouncementsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
@EnableAutoConfiguration(exclude={RabbitAutoConfiguration.class})
@EnableFeignClients("com.cb6.project.adminannouncementsservice")
@EnableEurekaClient
@SpringBootApplication
public class AdminAnnouncementsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminAnnouncementsServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}


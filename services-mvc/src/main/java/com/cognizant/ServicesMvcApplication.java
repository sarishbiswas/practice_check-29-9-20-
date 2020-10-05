package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicesMvcApplication{
	public static void main(String[] args) {
		SpringApplication.run(ServicesMvcApplication.class, args);
	}

}

package com.capstone.assignmentmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AssignmentmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentmicroserviceApplication.class, args);
	}

}

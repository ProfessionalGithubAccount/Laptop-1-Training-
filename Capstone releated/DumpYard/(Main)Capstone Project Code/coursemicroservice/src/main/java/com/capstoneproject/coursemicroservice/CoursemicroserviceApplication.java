package com.capstoneproject.coursemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.capstoneproject.coursemicroservice.repository")
public class CoursemicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursemicroserviceApplication.class, args);
	}

}

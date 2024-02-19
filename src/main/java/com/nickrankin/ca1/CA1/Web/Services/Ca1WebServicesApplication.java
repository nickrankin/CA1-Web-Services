package com.nickrankin.ca1.CA1.Web.Services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/tutorials/rest

@SpringBootApplication
public class Ca1WebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ca1WebServicesApplication.class, args);
	}

}

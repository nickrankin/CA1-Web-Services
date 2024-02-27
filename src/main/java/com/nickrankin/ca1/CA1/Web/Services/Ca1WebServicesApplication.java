package com.nickrankin.ca1.CA1.Web.Services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// https://spring.io/guides/tutorials/rest
@SpringBootApplication
public class Ca1WebServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(Ca1WebServicesApplication.class, args);

	}


	@Configuration
	public class MvcConfig implements WebMvcConfigurer {

		// Enables live reload for working with VueJS:
		// https://stackoverflow.com/questions/52162041/spring-boot-triggers-full-restart-instead-of-reload-on-changes-over-static-files
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		}

		// for testing purposes turn off cors
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedMethods("*");
		}
	}

}

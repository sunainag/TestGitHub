package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootApplication  extends SpringBootServletInitializer{

	/*Used when run as a JAR*/
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	/*Used when run as a WAR*/
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootApplication.class);
	}
	
	
}

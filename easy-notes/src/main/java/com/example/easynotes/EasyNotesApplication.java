package com.example.easynotes;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.easynotes.controller.NoteController;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackageClasses = {NoteController.class})
public class EasyNotesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EasyNotesApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(EasyNotesApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}

package com.example.demo;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;



@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		 SpringApplication app = new SpringApplication(DemoApplication.class);
	        app.setDefaultProperties(Collections
	          .singletonMap("server.port", "8089"));
	        app.run(args);
		
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
			//	System.out.println(beanName);
			}

		};
	}
	
}

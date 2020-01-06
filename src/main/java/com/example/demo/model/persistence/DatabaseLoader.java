package com.example.demo.model.persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {
	@Bean
	CommandLineRunner init(WebHookRepository repository) {
		System.out.println("Loading Repository:");
		return args -> {
			//BKD=BOOKED,MVT=MOVEMENT
			repository.save(new WebHook("Freight Forward Corp","http://localhost:8089/waybill/status","BKD"));
			repository.save(new WebHook("Movement Tracker Corp","http://localhost:8089/waybill/status","MVT"));
			
		};
	}
}

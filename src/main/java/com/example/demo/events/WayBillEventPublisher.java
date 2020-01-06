package com.example.demo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
@Component
public class WayBillEventPublisher {
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
 
    public void doPublishAnEvent(WayBillEvent event,final String message) {
        System.out.println("Publishing custom event. ");
       // WayBillEvent customSpringEvent = new WayBillEvent(this, message);
        applicationEventPublisher.publishEvent(event);
    }

	
}

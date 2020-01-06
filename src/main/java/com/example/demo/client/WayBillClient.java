package com.example.demo.client;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.events.WayBillEvent;
import com.example.demo.events.WayBillEventPublisher;
import com.example.demo.model.persistence.CargoWayBill;
@Component
public class WayBillClient{
	
	@Autowired
	WayBillEventPublisher wayBillEventPublisher ;
	
	public CargoWayBill getWayBill(Map<String,String> params) {
		 RestTemplate restTemplate = new RestTemplate();
		 String url = null;
		 CargoWayBill result = restTemplate.getForObject(url, CargoWayBill.class, params);
		 return result;
		 
	}
	public List<CargoWayBill> getAllWayBills(){
		return null;
	}
	
	public CargoWayBill createWayBill(CargoWayBill request,String eventStatus) {
		 //create the waybill in DB
		 RestTemplate restTemplate = new RestTemplate();
		 final String url = "http://localhost:8089/waybill";
		 CargoWayBill result = restTemplate.postForObject(url, request, CargoWayBill.class);
		 
		 //create the new waybill event
		 WayBillEvent newWayBillEvent = new WayBillEvent(result,"CREATE",eventStatus);
		 
		 wayBillEventPublisher.doPublishAnEvent(newWayBillEvent, "Create event");

		 return result;
	}
	public CargoWayBill updateWayBill(CargoWayBill request,String eventStatus) {
		
		//update the waybill in DB
		 RestTemplate restTemplate = new RestTemplate();
		 final String url = "http://localhost:8089/waybill/location";
		 CargoWayBill result = restTemplate.postForObject(url, request, CargoWayBill.class);
		
		//update the waybill event
		 
		 WayBillEvent updatedWayBillEvent = new WayBillEvent(result,"UPDATE",eventStatus);
		 wayBillEventPublisher.doPublishAnEvent(updatedWayBillEvent, "Update event");
		 return result;
	}
	
}

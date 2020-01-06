package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.client.WayBillClient;
import com.example.demo.model.persistence.CargoWayBill;

@Service
public class WayBillKafkaConsumer {
	@Autowired
	WayBillClient client;
	@KafkaListener(topics = "waybill", groupId = "group_id")
	public void consume(String message) {
		//message [CREATE|UPDATE:WAYBILLNUMBER:LOCATION:BKD|MVT]
		 System.out.println("Received message: " + message);
		 String[] result = message.split(":");		 
		 String type = result[0];
		 String billNumber = result[1];
		 String location = result[2];
		 String eventStatus = result[3];
		 CargoWayBill wayBill = new CargoWayBill();
		 wayBill.setWaybillLocation(location);
		 wayBill.setWaybillNumber(billNumber);
		
		 
		 if("CREATE".equalsIgnoreCase(type)) {
			 
			 client.createWayBill(wayBill,eventStatus);
		 }else if("UPDATE".equalsIgnoreCase(type)) {
			
			 client.updateWayBill(wayBill,eventStatus);
		 }else {
			 System.out.println(" Unknown Message state");
		 }
		 
	}

}

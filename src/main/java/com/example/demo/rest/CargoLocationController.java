package com.example.demo.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.events.WayBillEvent;
import com.example.demo.model.persistence.CargoWayBill;
import com.example.demo.model.persistence.WayBillRepository;



@RestController
public class CargoLocationController {
	
	private final WayBillRepository repository;
	public CargoLocationController(WayBillRepository wayBillRepository) {
		repository  = wayBillRepository;
	}
	
	@PostMapping("/waybill")
	ResponseEntity<?> newcargoWayBill(@RequestBody CargoWayBill cargoWayBill) {

		try {

			CargoWayBill response = repository.save(cargoWayBill);
			return ResponseEntity.ok(response);
					
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to create WayBill with Number " +  cargoWayBill.getWaybillNumber());
		}
	}
	
	@PostMapping("/waybill/location")
	ResponseEntity<?> changeWayBillLocation(@RequestBody CargoWayBill cargoWayBill) {

		try {

			CargoWayBill response = repository.save(cargoWayBill);
			return ResponseEntity.ok(response);
					
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to create WayBill with Number " +  cargoWayBill.getWaybillNumber());
		}
	}
	@PostMapping("/waybill/status")
	ResponseEntity<?> status(@RequestBody WayBillEvent wayBillEvent) {
		
		CargoWayBill cargoWayBill = (CargoWayBill)wayBillEvent.getSource();
		try {
			
			System.out.println(" >>>>>>>>>>>>> WayBill Number : " + cargoWayBill.getWaybillNumber() + " current shipment location is : " + cargoWayBill.getWaybillLocation());
			
			return ResponseEntity.ok(cargoWayBill);
					
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to sent WayBill status with Number " +  cargoWayBill.getWaybillNumber() );
		}
	}
	
	@PostMapping("/waybill/status/company")
	ResponseEntity<?> companyStatus(@RequestBody WayBillEvent wayBillEvent) {
		
		CargoWayBill cargoWayBill = (CargoWayBill)wayBillEvent.getSource();
		try {
			
			System.out.println(" >>>>>>>>>>>>> WayBill Number : " + cargoWayBill.getWaybillNumber() + " current shipment location is : " + cargoWayBill.getWaybillLocation());
			
			return ResponseEntity.ok(cargoWayBill);
					
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to sent WayBill status with Number " +  cargoWayBill.getWaybillNumber() );
		}
	}
	
	
}

package com.example.demo.model.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CargoWayBill")

public class CargoWayBill {
	
	@Id	 private String waybillNumber;	
	@Column(nullable = false, unique = false) 
	String waybillLocation;
	public CargoWayBill() {
		super();
	}
	public String getWaybillNumber() {
		return waybillNumber;
	}
	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber;
	}
	public String getWaybillLocation() {
		return waybillLocation;
	}
	public void setWaybillLocation(String waybillLocation) {
		this.waybillLocation = waybillLocation;
	}

}

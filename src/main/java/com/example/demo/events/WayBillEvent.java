package com.example.demo.events;

import org.springframework.context.ApplicationEvent;

import com.example.demo.model.persistence.CargoWayBill;



public class WayBillEvent extends ApplicationEvent{
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6977329430245604744L;
	private String message;
	String type;
	public WayBillEvent(CargoWayBill source, String message,String type) {
        super(source);
        this.message = message;
        this.type = type;
    }
    public String getMessage() {
        return message;
    }

}

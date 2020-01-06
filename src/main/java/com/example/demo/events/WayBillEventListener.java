package com.example.demo.events;

import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.client.WebHookClient;
import com.example.demo.model.persistence.CargoWayBill;
import com.example.demo.model.persistence.WebHook;
import com.example.demo.slack.webhook.SlackMessage;
import com.example.demo.slack.webhook.SlackUtils;

@Component
public class WayBillEventListener implements ApplicationListener<WayBillEvent>{
	@Override
    public void onApplicationEvent(WayBillEvent event)  {
		CargoWayBill cargoWayBill = (CargoWayBill)event.getSource(); 
        System.out.println("Received  WayBill event :  " + event.getMessage() + " : " +  cargoWayBill.getWaybillNumber() + " : " + event.getType());
        //1.get the webhook subscribers
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      callAllWebHooks(event); 
    }
	
	private void callAllWebHooks(WayBillEvent event) {
		WebHookClient webHookClient = new WebHookClient();
		List<WebHook> webHooks = webHookClient.getAllSubcribers();
		RestTemplate restTemplate = new RestTemplate();
        
		for (WebHook webHook : webHooks) {
		    String url = webHook.getUrl();
	        String webHook4Event = webHook.getType();
	        if(webHook4Event.equalsIgnoreCase(event.getType())) {
	        System.out.println("WebHook for Company ->>>>>>>>>>>>>>>>>>> " + webHook.getCompany());	
	        CargoWayBill result = restTemplate.postForObject(url, event, CargoWayBill.class);
	        System.out.println("WAYBILL Number " +  result.getWaybillNumber() + " Location is ---------------------------- > " + result.getWaybillLocation());
	        dosendToSlack(event);
	        }
	        
		}
	}
	
	private void dosendToSlack(WayBillEvent event) {
		CargoWayBill cargoWayBill = (CargoWayBill)event.getSource();
		 String msg =  " WayBill Number : " + cargoWayBill.getWaybillNumber() + " current shipment location is : " + cargoWayBill.getWaybillLocation();
		 SlackMessage slackMessage = new SlackMessage("pritam.dewan",msg);
		 SlackUtils.sendMessage(slackMessage);
	}
}

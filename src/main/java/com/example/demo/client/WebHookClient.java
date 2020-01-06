package com.example.demo.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.persistence.WebHook;

public class WebHookClient {

	public WebHookClient() {
		super();
	}
	public List<WebHook> getSubcribers() {
		
		final String url = "http://localhost:8089/webhooks";
		 RestTemplate restTemplate = new RestTemplate();
			
		 List<WebHook> result = (List<WebHook>) restTemplate.getForObject(url, WebHook.class);
		 return result;
		

	}
	 public List<WebHook> getAllSubcribers() {
	        RestTemplate restTemplate = new RestTemplate();
	        final String url = "http://localhost:8089/webhooks";
	        ResponseEntity<List<WebHook>> response =
	                restTemplate.exchange(
	                		url,
	                        HttpMethod.GET,
	                        null,
	                        new ParameterizedTypeReference<List<WebHook>>() {
	                        });

	        List<WebHook> webHook = response.getBody();

	        assert webHook != null;
	       // webHook.forEach(System.out::println);

	        return webHook;
	    }
	
	public WebHook getSubcriberById(String id) {
		
		final String url = "http://localhost:8089/webhooks/{id}";
		 RestTemplate restTemplate = new RestTemplate();
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("id", id);	
		 WebHook result = restTemplate.getForObject(url, WebHook.class,params);
		 return result;
		

	}
}

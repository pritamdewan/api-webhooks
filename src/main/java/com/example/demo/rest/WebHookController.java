package com.example.demo.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.persistence.WebHook;
import com.example.demo.model.persistence.WebHookRepository;

@RestController

public class WebHookController {
	private final WebHookRepository repository;

	WebHookController(WebHookRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping(path="/webhooks")
	
	public List<WebHook> findAll(){
		Iterable<WebHook> itrable = repository.findAll();
		Iterator<WebHook> itr = itrable.iterator();
		List<WebHook> webhooks = new ArrayList<WebHook>();
		while (itr.hasNext()) {
			webhooks.add(itr.next());
		}
	return webhooks;
	}
	
	
//	ResponseEntity<CollectionModel<WebHook>> findAll() {
//	
//		Iterable<WebHook> itrable = repository.findAll();
//		Iterator<WebHook> itr = itrable.iterator();
//		List<WebHook> webhooks = new ArrayList<WebHook>();
//		while (itr.hasNext()) {
//			webhooks.add(itr.next());
//		}
//		CollectionModel<WebHook> model = new CollectionModel<>(webhooks);
//
//		return ResponseEntity.ok(model);
//	}	 
	
	@GetMapping("/webhooks/{id}")
	ResponseEntity<WebHook> findOne(@PathVariable long id) {
		Optional<WebHook> webhook = repository.findById(id);
		if(webhook.isPresent()) {
			/*
			List<WebHook> webhooks = new ArrayList<WebHook>();
		
			 * webhooks.add(webhook.get()); CollectionModel<WebHook> model = new
			 * CollectionModel<>(webhooks);
			 */
			return new ResponseEntity<WebHook>(webhook.get(), HttpStatus.OK);
			//return ResponseEntity.ok(model);
		}else {
		//	return ResponseEntity.notFound().build();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			//return (ResponseEntity<CollectionModel<WebHook>>) ResponseEntity.badRequest();
		}
		
		
	}
	
	@PostMapping("/webhooks/subscribe")

	ResponseEntity<?> newWebHook(@RequestBody WebHook webhook) {

		try {
	//		WebHook dummy = new WebHook("ZCorp","localhost:8089/");
			WebHook webHook = repository.save(webhook);
			return ResponseEntity.ok(webHook);
					
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Unable to create Webhook" );
		}
	}
	
	
}

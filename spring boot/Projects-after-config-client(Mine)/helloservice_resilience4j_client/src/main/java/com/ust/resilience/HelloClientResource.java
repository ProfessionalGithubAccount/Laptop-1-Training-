package com.ust.resilience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/client")
public class HelloClientResource {
	
	@Autowired
	RestTemplate template;
	
	public final static String CLIENT_SERVICE="clientService";
	
	@GetMapping
	@CircuitBreaker(name=CLIENT_SERVICE,fallbackMethod="callOnFail_Mine")
	public String callServer() {
		String url="http://localhost:8071/rest/service";
		
		String output=template.getForObject(url,String.class);
		return output;
	}//Lets call this as working method

	public String callOnFail_Mine(Exception e) {
		return "message from callonfail method created by me.....";
	}//lets call this as fallback method 
//IMportant Point: Both working and fallback method should have same return type..else wont work..if one a String or response entity other shoulf also have response entity
}

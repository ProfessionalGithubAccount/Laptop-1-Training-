package com.iiht.restjpa.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/rest/service")
public class HelloController {
	
	@GetMapping
	public String confirm(@RequestHeader HttpHeaders header) {
		return "connected...good job"+header;//@RequestHeader HttpHeaders header..this one is for checking the filter function..to see hello world
	}
	
	@GetMapping("/evenodd/{num}")
	public String evenodd(@PathVariable int num) {
		return num%2==0?"Even":"Odd";
	}
	
	@GetMapping("/factorial/{num}")
	public int factorial(@PathVariable int num) {
		if(num==0 || num==1)
			return 1;
		return num*factorial(num-1);
		
	}

}

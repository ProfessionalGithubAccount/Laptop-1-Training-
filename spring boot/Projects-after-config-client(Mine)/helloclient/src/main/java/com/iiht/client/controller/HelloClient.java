package com.iiht.client.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//ctrl+shift+o..to import all dependeices in this file...to get all required import statements
@RestController
@RequestMapping("/rest/client")
public class HelloClient {
    
	
	@Autowired
	RestTemplate template;
	
	@GetMapping
	public String connect() {
		/* String url="http://localhost:8071/rest/service"; */
		 String url="http://localhost:8093/rest/service"; //api gateway url //Now the gateway is between client and service
		 //Enter te client port number/rest/client in url of browser
		ResponseEntity<String> response=template.getForEntity(url, String.class);
		return response.toString(); 
	}
	
	@GetMapping("/{n}")
	public String evenodd(@PathVariable int n) {
		String url="http://localhost:8093/rest/service/evenodd/"+n;
		ResponseEntity<String> response=template.getForEntity(url,String.class);
		return response.toString();
	}
	
	@GetMapping("/factorial/{num}")
	public String factorial(@PathVariable int num) {
		String url="http://localhost:8093/rest/service/factorial/"+num;
		ResponseEntity<String> response=template.getForEntity(url,String.class);
		return response.toString();
	}


}

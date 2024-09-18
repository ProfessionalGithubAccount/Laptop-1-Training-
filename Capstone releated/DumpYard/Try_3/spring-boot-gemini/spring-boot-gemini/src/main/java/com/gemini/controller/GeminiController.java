package com.gemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemini.serviceImpl.GeminiService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GeminiController {
	
	@Autowired
	GeminiService geminiService;

	@GetMapping("/hello")
	public String sample(){
		return "HEllo";
	}
	
	@GetMapping("/prompt/{prompt}/{geminiKey}")
	public String getResponse(String prompt, String geminiKey) {
		return geminiService.callApi(prompt,geminiKey);
		
	}
}

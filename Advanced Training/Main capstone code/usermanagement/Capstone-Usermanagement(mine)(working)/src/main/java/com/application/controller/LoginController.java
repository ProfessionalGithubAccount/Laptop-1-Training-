package com.application.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.model.Professor;
import com.application.model.User;
import com.application.services.JwtService;
import com.application.services.ProfessorService;
import com.application.services.UserService;

@RestController
public class LoginController 
{
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
    private JwtService jwtService;
	
	@GetMapping("/")
    public String welcomeMessage()
    {
    	return "Welcome to Elearning Management system !!!";
    }
	
	@GetMapping("/loginuser")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) throws Exception
	{
		Map<String, String> response = new HashMap<>();
		System.out.println(user);
	        if (userService.authenticate(user.getUsername(), user.getPassword())) {
//	            String token = jwtService.generateToken(user.getUsername());
	        	String token = jwtService.generateToken(user.getUsername());
	            response.put("token", token); // Include the token in the response
//	            response.put("studentId",Integer.toString(user.getStudentId()));
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("error", "Invalid credentials");
	            return ResponseEntity.status(401).body(response);
	        }
	}
	
	@GetMapping("/loginprofessor")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Map<String, String>> loginProfessor(@RequestBody Professor professor) throws Exception
	{
//		System.out.println(professor);
//		String currEmail = professor.getEmail();
//		String currPassword = professor.getPassword();
//
//		Professor professorObj = null;
//		if(currEmail != null && currPassword != null)
//		{
//			professorObj = professorService.fetchProfessorByEmailAndPassword(currEmail, currPassword);
//		}
//		if(professorObj == null)
//		{
//			throw new Exception("Professor does not exists!!! Please enter valid credentials...");
//		}
//		return professorObj;

		Map<String, String> response = new HashMap<>();
		System.out.println(professor);
		if (professorService.authenticate(professor.getEmail(), professor.getPassword())) {
//	            String token = jwtService.generateToken(user.getUsername());
			String token = jwtService.generateToken(professor.getEmail());
			response.put("token", token); // Include the token in the response
//	            response.put("studentId",Integer.toString(user.getStudentId()));
			return ResponseEntity.ok(response);
		} else {
			response.put("error", "Invalid credentials");
			return ResponseEntity.status(401).body(response);
		}
	}
}
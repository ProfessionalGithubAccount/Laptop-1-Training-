package com.serviceharbor.auth.controller;

import com.serviceharbor.auth.model.Professor;
import com.serviceharbor.auth.model.Student;


import com.serviceharbor.auth.service.JwtService;
import com.serviceharbor.auth.service.ProfessorService;
import com.serviceharbor.auth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RequestMapping("/user")
@RestController
public class UserController {
    private final StudentService studentService;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
    private ProfessorService professorService =new ProfessorService();

    @Autowired
    private JwtService jwtService;

    @GetMapping("/")
    public String welcomeMessage()
    {

        return "Welcome to Elearning Management system !!!";
    }



    public UserController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/authenticateuser")
    public ResponseEntity<Student> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Student currentStudent = (Student) authentication.getPrincipal();

        return ResponseEntity.ok(currentStudent);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<Student>> allUsers() {
        List <Student> students = studentService.allUsers();

        return ResponseEntity.ok(students);
    }

    @GetMapping("/service_provider")
    public ResponseEntity<Student> getProfileByRoleAndEmail(
            @RequestParam String role, @RequestParam String email) {
        try {
            Student student = studentService.getUserByRoleAndEmail(role, email);
            if (student != null) {
                return ResponseEntity.ok(student);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            // Log error and return bad request response
            return ResponseEntity.badRequest().body(null);
        }
    }



    @Autowired
    private StudentService userService;


    @GetMapping("/loginuser")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Student user) throws Exception
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
//
//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User newUser = userService.registerUser(user);
//        return ResponseEntity.ok(newUser);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(@RequestBody LoginRequest loginRequest) {
//        User user = userService.authenticateUser(loginRequest);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.status(401).build(); // Unauthorized
//        }
//    }
//
//      @GetMapping("/profile")
//    public ResponseEntity<User> getProfileByRoleAndUsername(@RequestParam String role, @RequestParam String username) {
//        User user = (User) userService.allUsers();
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @PostMapping("/authenticate")
//    public String authenticate(@RequestBody LoginRequest loginRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
//            );
//
//            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
//            return jwtUtil.generateToken(userDetails.getUsername());
//        } catch (AuthenticationException e) {
//            throw new Exception("Invalid username or password", e);
//        }
//    }

    // Other endpoints related to user management

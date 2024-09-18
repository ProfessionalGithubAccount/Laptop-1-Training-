package com.serviceharbor.auth.controller;


import com.serviceharbor.auth.dtos.LoginProfessorDto;
import com.serviceharbor.auth.dtos.LoginStudentDto;
import com.serviceharbor.auth.dtos.RegisterStudentDto;
import com.serviceharbor.auth.model.Professor;
import com.serviceharbor.auth.model.Student;
import com.serviceharbor.auth.responses.LoginResponse;
import com.serviceharbor.auth.service.AuthenticationService;
import com.serviceharbor.auth.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationServicestudent;
    private final AuthenticationService authenticationServiceprofessor;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationServicestudent = authenticationService;
        this.authenticationServiceprofessor=authenticationService;
    }

    @PostMapping("/registerstudent")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        System.out.println("Control"+student);
        Student registeredStudent = authenticationServicestudent.signupStudent(student);

        return ResponseEntity.ok(registeredStudent);
    }
    @PostMapping("/registerprofessor")
    public ResponseEntity<Professor> registerProfessor(@RequestBody Professor professor) {
        Professor registeredProfessor = authenticationServiceprofessor.signupProfessor(professor);

        return ResponseEntity.ok(registeredProfessor);
    }

    @PostMapping("/loginstudent")
    public ResponseEntity<LoginResponse> authenticateStudent(@RequestBody LoginStudentDto loginStudentDto) {
        Student authenticatedStudent = authenticationServicestudent.authenticate(loginStudentDto);

        String jwtToken = jwtService.generateToken(authenticatedStudent.toString());

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }


    @PostMapping("/loginprofessor")
    public ResponseEntity<LoginResponse> authenticateProfessor(@RequestBody LoginProfessorDto loginprofessordto) {
        String authenticatedProfessor = authenticationServiceprofessor.authenticate(loginprofessordto);

        String jwtToken = jwtService.generateToken(String.valueOf(authenticatedProfessor));

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
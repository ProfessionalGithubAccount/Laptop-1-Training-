package com.serviceharbor.auth.controller;


import com.serviceharbor.auth.dtos.LoginUserDto;
import com.serviceharbor.auth.dtos.RegisterUserDto;
import com.serviceharbor.auth.model.Role;
import com.serviceharbor.auth.model.User;
import com.serviceharbor.auth.responses.LoginResponse;
import com.serviceharbor.auth.service.AuthenticationService;
import com.serviceharbor.auth.service.JwtService;
import com.serviceharbor.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        Role role = userService.getUserByEmail(loginUserDto.getEmail()).getRole();
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime()).setRole(role);
        return ResponseEntity.ok(loginResponse);
    }
}
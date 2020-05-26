package com.cloudtech.spring.controller;

import com.cloudtech.spring.configuration.AuthenticationRequest;
import com.cloudtech.spring.configuration.AuthenticationResponse;
import com.cloudtech.spring.configuration.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @Autowired
    AuthenticationService service;

    @GetMapping(value = "/all")
    public String getAll() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping(value = "/user")
    public String getUser() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping(value = "/admin")
    public String getAdmin() {
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping(value = "/login")
    public ResponseEntity<AuthenticationRequest> login() {
        return ResponseEntity.ok(new AuthenticationRequest("user", "user"));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        final String token = service.authenticate(authenticationRequest);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
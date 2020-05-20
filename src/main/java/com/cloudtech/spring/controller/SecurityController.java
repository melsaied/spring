package com.cloudtech.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
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
}
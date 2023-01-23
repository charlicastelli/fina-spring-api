package com.castelli.finaspring.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castelli.finaspring.auth.model.AuthUser;
import com.castelli.finaspring.auth.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthUser Register(@RequestBody AuthUser user) {

        return  authService.register(user);


    }

    @PostMapping("/login")
    public AuthUser login(@RequestBody AuthUser user) {

        return authService.login(user);
    }
}

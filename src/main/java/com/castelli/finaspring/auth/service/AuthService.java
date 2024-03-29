package com.castelli.finaspring.auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castelli.finaspring.auth.model.AuthUser;
import com.castelli.finaspring.auth.repository.UserRepository;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64enocder = Base64.getUrlEncoder();


    public AuthUser register(AuthUser user) {
        // Check if user with username exist ir not
        if(checkUserExist(user)== true)
            return null;

        user.setToken(generateToken());

        return userRepository.save(user);

    }

    private String generateToken() {

        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64enocder.encodeToString(token);

    }

    private boolean checkUserExist(AuthUser user) {
        AuthUser existingUser = userRepository.findById(user.getUsername()).orElse(null);

        if(existingUser == null)
            return false;
        return true;
    }

    public AuthUser login(AuthUser user) {
        AuthUser existingUser = userRepository.findById(user.getUsername()).orElse(null);

        if(existingUser.getUsername().equals(user.getUsername()) &&
                existingUser.getPassword().equals(user.getPassword()) &&
                existingUser.getRole().equals(user.getRole())) {
            existingUser.setPassword("");
            return existingUser;
        }

        return null;

    }
    
}

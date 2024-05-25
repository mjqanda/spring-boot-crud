package com.example.crud.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.config.JwtTokenProvider;
import com.example.crud.model.AuthenticationRequest;
import com.example.crud.model.User;
import com.example.crud.service.UserService;

import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthenticationController {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    public AuthenticationController(JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, Object>> signin(@RequestBody AuthenticationRequest data) {
        Map<String, Object> model = new HashMap<>();
        try {
            log.info("signin start:: " + data.getUsername());

            // boolean isUserValid = userService.isUserExists(new User(data.getUsername(),
            // data.getPassword()));

            // if (isUserValid) {
            // Generate JWT token
            String token = jwtTokenProvider.createToken(data.getUsername());
            model.put("success", true);
            model.put("message", "Authentication successful");
            model.put("token", token);
            // } else {
            // model.put("success", false);
            // model.put("message", "Invalid username or password");
            // }
        } catch (Exception e) {
            model.put("success", false);
            model.put("message", "An error occurred during authentication");
            log.error("Error during authentication", e);
        }
        return ResponseEntity.ok(model);
    }

}
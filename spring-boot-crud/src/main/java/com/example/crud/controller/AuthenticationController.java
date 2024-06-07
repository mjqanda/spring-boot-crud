package com.example.crud.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.config.JwtTokenProvider;
import com.example.crud.model.User;
import com.example.crud.service.UserService;
import com.example.crud.util.ResponseWrapper;

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
    public ResponseEntity<ResponseWrapper> signin(@RequestBody User data) {
        try {
            log.info("Signin attempt for username: {}", data.getUsername());

            // boolean isUserValid = userService.isUserExists(new User(data.getUsername(),
            // data.getPassword()));

            // if (isUserValid) {
            String token = jwtTokenProvider.createToken(data.getUsername());
            log.info("Authentication successful for username: {}", data.getUsername());
            return ResponseEntity.ok(new ResponseWrapper(true, "Authentication successful", token));
            // } else {
            // log.warn("Authentication failed for username: {}", data.getUsername());
            // return ResponseEntity.ok(new ResponseWrapper(false, "Invalid username or
            // password", null));
            // }
        } catch (Exception e) {
            log.error("Error during authentication for username: {}", data.getUsername(), e);
            return ResponseEntity.status(500)
                    .body(new ResponseWrapper(false, "An error occurred during authentication", null));
        }
    }

}
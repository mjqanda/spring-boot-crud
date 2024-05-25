package com.example.crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationRequest {

    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public AuthenticationRequest(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

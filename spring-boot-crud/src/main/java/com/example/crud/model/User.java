package com.example.crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {

    @JsonProperty("username")
    private final String username;

    @JsonProperty("password")
    private final String password;

}

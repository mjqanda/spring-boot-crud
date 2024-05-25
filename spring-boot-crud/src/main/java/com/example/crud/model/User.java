package com.example.crud.model;

import lombok.Data;

@Data
public class User {

    public User(String userName, String password) {
        this.userName  = userName;
        this.password = password;
    }

    private Long id;
    private String userName;
    private String password;

}
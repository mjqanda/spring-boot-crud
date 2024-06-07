package com.example.crud.util;

import lombok.Data;

@Data
public class ResponseWrapper {
    
    private boolean success;
    private String message;
    private String token;

    public ResponseWrapper(boolean success, String message, String token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }
}

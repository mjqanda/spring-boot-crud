package com.example.crud.util;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseWrapper {
    private boolean success;
    private String message;
    private Map<String, Object> data;

    public ResponseWrapper(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}

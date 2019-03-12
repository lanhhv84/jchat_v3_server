package com.example.jchat_v3.controller;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class BaseController {
    public ResponseEntity ok(Object object) {
        HashMap<String, Object> val = new HashMap<>();
        val.put("value", object);
        return ResponseEntity.ok(val);
    }
}

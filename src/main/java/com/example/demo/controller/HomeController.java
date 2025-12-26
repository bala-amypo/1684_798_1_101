package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class HomeController {

    @GetMapping("/")  // maps the root URL
    public ResponseEntity<String> home() {
        return ResponseEntity.status(404).body("not Found");
    }
}

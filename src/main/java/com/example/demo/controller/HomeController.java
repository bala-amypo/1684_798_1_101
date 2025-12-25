package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")  // maps the root URL
    public String home() {
        return "Welcome to Smart Inventory!";
    }
}

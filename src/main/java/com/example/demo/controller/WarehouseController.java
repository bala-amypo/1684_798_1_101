package com.example.demo.controller;

// ✅ REQUIRED IMPORTS
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @GetMapping
    public String test() {
        return "Warehouse API working";
    }
}

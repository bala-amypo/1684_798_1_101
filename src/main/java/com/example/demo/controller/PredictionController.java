package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    @GetMapping("/next-restock")
    public ResponseEntity<LocalDate> predictRestockDate() {

        // Dummy prediction
        LocalDate predictedDate = LocalDate.now().plusDays(7);

        return ResponseEntity.ok(predictedDate);
    }
}

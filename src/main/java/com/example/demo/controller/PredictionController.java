package com.example.demo.controller;

import com.example.demo.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/predictions")
@RequiredArgsConstructor
public class PredictionController {
    
    private final PredictionService predictionService;
    
    @GetMapping("/stock-out/{stockRecordId}")
    public ResponseEntity<?> predictStockOutDays(@PathVariable Long stockRecordId) {
        int days = predictionService.predictStockOutDays(stockRecordId);
        
        if (days == -1) {
            return ResponseEntity.badRequest().body("Invalid prediction parameters");
        }
        
        return ResponseEntity.ok(Map.of("stockOutInDays", days));
    }
    
    @GetMapping("/average-consumption/{stockRecordId}")
    public ResponseEntity<?> calculateAverageDailyConsumption(
            @PathVariable Long stockRecordId,
            @RequestParam(defaultValue = "30") int days) {
        double average = predictionService.calculateAverageDailyConsumption(stockRecordId, days);
        return ResponseEntity.ok(Map.of("averageDailyConsumption", average));
    }
    
    @GetMapping("/critical/{stockRecordId}")
    public ResponseEntity<?> isStockCritical(@PathVariable Long stockRecordId) {
        boolean isCritical = predictionService.isStockCritical(stockRecordId);
        return ResponseEntity.ok(Map.of("isCritical", isCritical));
    }
    
    @GetMapping("/reorder-quantity/{stockRecordId}")
    public ResponseEntity<?> calculateReorderQuantity(@PathVariable Long stockRecordId) {
        int quantity = predictionService.calculateReorderQuantity(stockRecordId);
        return ResponseEntity.ok(Map.of("reorderQuantity", quantity));
    }
}
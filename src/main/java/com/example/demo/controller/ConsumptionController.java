package com.example.demo.controller;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/consumption")
@RequiredArgsConstructor
public class ConsumptionController {
    
    private final ConsumptionLogService consumptionLogService;
    
    @PostMapping
    public ResponseEntity<ConsumptionLog> logConsumption(@Valid @RequestBody ConsumptionLog consumptionLog) {
        return ResponseEntity.ok(consumptionLogService.logConsumption(consumptionLog));
    }
    
    @GetMapping("/stock-record/{stockRecordId}")
    public ResponseEntity<List<ConsumptionLog>> getLogsByStockRecord(@PathVariable Long stockRecordId) {
        // For now return empty list - you need to implement this in service if needed
        return ResponseEntity.ok(Collections.emptyList());
    }
}
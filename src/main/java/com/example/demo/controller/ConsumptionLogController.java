package com.example.demo.controller;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption-logs")
public class ConsumptionLogController {

    private final ConsumptionLogService consumptionLogService;

    public ConsumptionLogController(ConsumptionLogService consumptionLogService) {
        this.consumptionLogService = consumptionLogService;
    }

    @PostMapping
    public ResponseEntity<ConsumptionLog> createLog(
            @RequestBody ConsumptionLog log) {

        ConsumptionLog savedLog = consumptionLogService.createLog(log);
        return ResponseEntity.ok(savedLog);
    }

    @GetMapping("/stock/{stockRecordId}")
    public ResponseEntity<List<ConsumptionLog>> getLogsByStockRecord(
            @PathVariable Long stockRecordId) {

        return ResponseEntity.ok(
                consumptionLogService.getLogsByStockRecord(stockRecordId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumptionLog> getLog(@PathVariable Long id) {
        return ResponseEntity.ok(consumptionLogService.getLog(id));
    }
}

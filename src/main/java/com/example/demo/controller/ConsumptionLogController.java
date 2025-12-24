package com.example.demo.controller;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption")
@RequiredArgsConstructor
@Tag(name = "Consumption Log Management", description = "APIs for managing consumption logs")
public class ConsumptionLogController {

    private final ConsumptionLogService consumptionLogService;

    @PostMapping("/{stockRecordId}")
    @Operation(summary = "Log consumption for a stock record")
    public ResponseEntity<ConsumptionLog> logConsumption(
            @PathVariable Long stockRecordId,
            @RequestBody ConsumptionLog consumptionLog) {
        ConsumptionLog createdLog = consumptionLogService.logConsumption(stockRecordId, consumptionLog);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLog);
    }

    @GetMapping("/record/{stockRecordId}")
    @Operation(summary = "Get consumption logs by stock record ID")
    public ResponseEntity<List<ConsumptionLog>> getLogsByStockRecord(@PathVariable Long stockRecordId) {
        List<ConsumptionLog> logs = consumptionLogService.getLogsByStockRecord(stockRecordId);
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get consumption log by ID")
    public ResponseEntity<ConsumptionLog> getLog(@PathVariable Long id) {
        ConsumptionLog log = consumptionLogService.getLog(id);
        return ResponseEntity.ok(log);
    }
}
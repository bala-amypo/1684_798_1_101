package com.example.demo.controller;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {
    
    private final StockRecordService stockRecordService;
    
    @PostMapping
    public ResponseEntity<StockRecord> createStockRecord(@Valid @RequestBody StockRecord stockRecord) {
        return ResponseEntity.ok(stockRecordService.createStockRecord(stockRecord));
    }
    
    @GetMapping
    public ResponseEntity<List<StockRecord>> getAllStockRecords() {
        return ResponseEntity.ok(stockRecordService.getAllStockRecords());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StockRecord> getStockRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(stockRecordService.getStockRecordById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StockRecord> updateStockRecord(
            @PathVariable Long id, 
            @Valid @RequestBody StockRecord stockRecord) {
        return ResponseEntity.ok(stockRecordService.updateStockRecord(id, stockRecord));
    }
}
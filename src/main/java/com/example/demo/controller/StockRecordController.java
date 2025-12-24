package com.example.demo.controller;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
@Tag(name = "Stock Record Management", description = "APIs for managing stock records")
public class StockRecordController {

    private final StockRecordService stockRecordService;

    @PostMapping("/{productId}/{warehouseId}")
    @Operation(summary = "Create a new stock record")
    public ResponseEntity<StockRecord> createStockRecord(
            @PathVariable Long productId,
            @PathVariable Long warehouseId,
            @RequestBody StockRecord stockRecord) {
        StockRecord createdRecord = stockRecordService.createStockRecord(productId, warehouseId, stockRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get stock record by ID")
    public ResponseEntity<StockRecord> getStockRecord(@PathVariable Long id) {
        StockRecord stockRecord = stockRecordService.getStockRecord(id);
        return ResponseEntity.ok(stockRecord);
    }

    @GetMapping("/product/{productId}")
    @Operation(summary = "Get stock records by product ID")
    public ResponseEntity<List<StockRecord>> getRecordsByProduct(@PathVariable Long productId) {
        List<StockRecord> records = stockRecordService.getRecordsBy_product(productId);
        return ResponseEntity.ok(records);
    }

    @GetMapping("/warehouse/{warehouseId}")
    @Operation(summary = "Get stock records by warehouse ID")
    public ResponseEntity<List<StockRecord>> getRecordsByWarehouse(@PathVariable Long warehouseId) {
        List<StockRecord> records = stockRecordService.getRecordsByWarehouse(warehouseId);
        return ResponseEntity.ok(records);
    }
}
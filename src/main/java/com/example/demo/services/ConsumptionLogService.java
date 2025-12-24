package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumptionLogService {
    private final ConsumptionLogRepository consumptionLogRepository;
    private final StockRecordService stockRecordService;
    
    public ConsumptionLog logConsumption(Long stockRecordId, ConsumptionLog consumptionLog) {
        StockRecord stockRecord = stockRecordService.getStockRecord(stockRecordId);
        
        // Validate consumed date is not in the future
        if (consumptionLog.getConsumedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("consumedDate cannot be in the future");
        }
        
        // Update stock quantity
        int newQuantity = stockRecord.getCurrentQuantity() - consumptionLog.getConsumedQuantity();
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        
        stockRecord.setCurrentQuantity(newQuantity);
        consumptionLog.setStockRecord(stockRecord);
        
        return consumptionLogRepository.save(consumptionLog);
    }
    
    public List<ConsumptionLog> getLogsByStockRecord(Long stockRecordId) {
        return consumptionLogRepository.findByStockRecordId(stockRecordId);
    }
}
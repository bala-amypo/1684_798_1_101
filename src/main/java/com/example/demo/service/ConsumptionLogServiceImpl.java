package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.StockRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ConsumptionLogServiceImpl implements ConsumptionLogService {
    
    private final ConsumptionLogRepository consumptionLogRepository;
    private final StockRecordRepository stockRecordRepository;
    
    @Override
    public ConsumptionLog logConsumption(ConsumptionLog consumptionLog) {
        // Set consumption date if not set
        if (consumptionLog.getConsumedDate() == null) {
            consumptionLog.setConsumedDate(LocalDate.now());
        }
        
        // Update stock record
        StockRecord stockRecord = consumptionLog.getStockRecord();
        int currentQuantity = stockRecord.getCurrentQuantity();
        int consumedQuantity = consumptionLog.getConsumedQuantity();
        
        if (currentQuantity < consumedQuantity) {
            throw new RuntimeException("Insufficient stock");
        }
        
        stockRecord.setCurrentQuantity(currentQuantity - consumedQuantity);
        stockRecordRepository.save(stockRecord);
        
        // Save consumption log
        consumptionLog.setStockRecord(stockRecord);
        return consumptionLogRepository.save(consumptionLog);
    }
}
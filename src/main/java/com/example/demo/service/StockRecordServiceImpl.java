package com.example.demo.service;

import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StockRecordServiceImpl implements StockRecordService {
    
    private final StockRecordRepository stockRecordRepository;
    
    @Override
    public StockRecord createStockRecord(StockRecord stockRecord) {
        return stockRecordRepository.save(stockRecord);
    }
    
    @Override
    public List<StockRecord> getAllStockRecords() {
        return stockRecordRepository.findAll();
    }
    
    @Override
    public StockRecord getStockRecordById(Long id) {
        return stockRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock record not found with id: " + id));
    }
    
    @Override
    public StockRecord updateStockRecord(Long id, StockRecord stockRecordDetails) {
        StockRecord stockRecord = getStockRecordById(id);
        stockRecord.setCurrentQuantity(stockRecordDetails.getCurrentQuantity());
        stockRecord.setReorderLevel(stockRecordDetails.getReorderLevel());
        return stockRecordRepository.save(stockRecord);
    }
}
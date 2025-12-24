package com.example.demo.service;

import com.example.demo.model.StockRecord;
import java.util.List;

public interface StockRecordService {
    StockRecord createStockRecord(StockRecord stockRecord);
    List<StockRecord> getAllStockRecords();
    StockRecord getStockRecordById(Long id);
    StockRecord updateStockRecord(Long id, StockRecord stockRecord);
}
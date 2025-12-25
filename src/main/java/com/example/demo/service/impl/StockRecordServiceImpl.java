package com.example.demo.service.impl;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockRecordServiceImpl implements StockRecordService {

    @Override
    public StockRecord save(StockRecord record) {
        return record;
    }

    @Override
    public List<StockRecord> findAll() {
        return new ArrayList<>();
    }
}

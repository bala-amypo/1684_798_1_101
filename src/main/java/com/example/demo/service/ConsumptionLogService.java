package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.repository.ConsumptionLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionLogService {

    private final ConsumptionLogRepository repo;

    public ConsumptionLogService(ConsumptionLogRepository repo) {
        this.repo = repo;
    }

    public ConsumptionLog logConsumption(long stockRecordId, ConsumptionLog log) {
        return repo.save(log);
    }

    public List<ConsumptionLog> getLogsByStockRecord(long stockRecordId) {
        return repo.findByStockRecordIdOrderByConsumedDateDesc(stockRecordId);
    }
}

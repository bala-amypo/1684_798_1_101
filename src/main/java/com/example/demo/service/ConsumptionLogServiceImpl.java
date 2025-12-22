package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.repository.ConsumptionLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ THIS IS CRITICAL
public class ConsumptionLogServiceImpl implements ConsumptionLogService {

    private final ConsumptionLogRepository repository;

    public ConsumptionLogServiceImpl(ConsumptionLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ConsumptionLog saveConsumption(ConsumptionLog log) {
        return repository.save(log);
    }

    @Override
    public List<ConsumptionLog> getAllConsumptions() {
        return repository.findAll();
    }
}

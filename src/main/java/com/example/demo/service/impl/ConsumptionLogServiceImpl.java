package com.example.demo.service.impl;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumptionLogServiceImpl implements ConsumptionLogService {

    @Override
    public ConsumptionLog save(ConsumptionLog log) {
        return log;
    }

    @Override
    public List<ConsumptionLog> findAll() {
        return new ArrayList<>();
    }
}

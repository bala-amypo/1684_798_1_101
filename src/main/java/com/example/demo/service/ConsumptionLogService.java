package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;

import java.util.List;

public interface ConsumptionLogService {

    /**
     * Create a new consumption log entry
     */
    ConsumptionLog createLog(ConsumptionLog log);

    /**
     * Get all logs for a given StockRecord
     */
    List<ConsumptionLog> getLogsByStockRecord(Long stockRecordId);

    /**
     * Get a single consumption log by ID
     */
    ConsumptionLog getLog(Long id);
}

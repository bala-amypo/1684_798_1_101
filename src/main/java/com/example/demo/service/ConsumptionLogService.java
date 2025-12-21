package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import java.util.List;

public interface ConsumptionLogService {

    ConsumptionLog createLog(ConsumptionLog log);

    List<ConsumptionLog> getLogsByStockRecord(Long stockRecordId);

    ConsumptionLog getLog(Long id);
}

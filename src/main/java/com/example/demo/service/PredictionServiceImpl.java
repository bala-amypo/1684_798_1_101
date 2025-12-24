package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PredictionServiceImpl implements PredictionService {
    
    private final PredictionRuleRepository predictionRuleRepository;
    private final StockRecordRepository stockRecordRepository;
    private final ConsumptionLogRepository consumptionLogRepository;
    
    @Override
    public int predictStockOutDays(Long stockRecordId) {
        Optional<StockRecord> stockRecordOpt = stockRecordRepository.findById(stockRecordId);
        Optional<PredictionRule> ruleOpt = predictionRuleRepository.findById(1L);
        
        if (stockRecordOpt.isEmpty() || ruleOpt.isEmpty()) {
            return -1;
        }
        
        StockRecord stockRecord = stockRecordOpt.get();
        PredictionRule rule = ruleOpt.get();
        
        int minDailyUsage = rule.getMinDailyUsage();
        int currentQuantity = stockRecord.getCurrentQuantity();
        
        if (minDailyUsage <= 0) {
            return -1;
        }
        
        return currentQuantity / minDailyUsage;
    }
    
    @Override
    public double calculateAverageDailyConsumption(Long stockRecordId, int days) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(days);
        
        List<ConsumptionLog> logs = consumptionLogRepository
                .findByStockRecordIdAndConsumedDateBetween(stockRecordId, startDate, endDate);
        
        if (logs.isEmpty()) {
            return 0.0;
        }
        
        int totalConsumption = logs.stream()
                .mapToInt(ConsumptionLog::getConsumedQuantity)
                .sum();
        
        long actualDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return (double) totalConsumption / actualDays;
    }
    
    @Override
    public boolean isStockCritical(Long stockRecordId) {
        Optional<StockRecord> stockRecordOpt = stockRecordRepository.findById(stockRecordId);
        Optional<PredictionRule> ruleOpt = predictionRuleRepository.findById(1L);
        
        if (stockRecordOpt.isEmpty() || ruleOpt.isEmpty()) {
            return false;
        }
        
        StockRecord stockRecord = stockRecordOpt.get();
        PredictionRule rule = ruleOpt.get();
        
        int minDailyUsage = rule.getMinDailyUsage();
        int currentQuantity = stockRecord.getCurrentQuantity();
        
        return currentQuantity <= (minDailyUsage * rule.getLeadTimeDays() + rule.getSafetyStock());
    }
    
    @Override
    public int calculateReorderQuantity(Long stockRecordId) {
        Optional<StockRecord> stockRecordOpt = stockRecordRepository.findById(stockRecordId);
        Optional<PredictionRule> ruleOpt = predictionRuleRepository.findById(1L);
        
        if (stockRecordOpt.isEmpty() || ruleOpt.isEmpty()) {
            return 0;
        }
        
        StockRecord stockRecord = stockRecordOpt.get();
        PredictionRule rule = ruleOpt.get();
        
        int maxDailyUsage = rule.getMaxDailyUsage();
        int leadTimeDays = rule.getLeadTimeDays();
        int safetyStock = rule.getSafetyStock();
        int currentQuantity = stockRecord.getCurrentQuantity();
        
        int requiredQuantity = (maxDailyUsage * leadTimeDays) + safetyStock;
        return Math.max(0, requiredQuantity - currentQuantity);
    }
}
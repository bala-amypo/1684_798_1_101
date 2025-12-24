package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PredictionService {
    private final PredictionRuleRepository predictionRuleRepository;
    private final ConsumptionLogRepository consumptionLogRepository;
    private final StockRecordService stockRecordService;
    
    public PredictionRule createRule(PredictionRule rule) {
        return predictionRuleRepository.save(rule);
    }
    
    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }
    
    public LocalDate predictRestockDate(Long stockRecordId) {
        StockRecord stockRecord = stockRecordService.getStockRecord(stockRecordId);
        List<PredictionRule> rules = getAllRules();
        
        if (rules.isEmpty()) {
            // Default fallback
            return LocalDate.now().plusDays(7);
        }
        
        PredictionRule rule = rules.get(0); // Use first rule
        
        // Calculate average daily consumption
        LocalDate startDate = LocalDate.now().minusDays(rule.getAverageDaysWindow());
        List<ConsumptionLog> logs = consumptionLogRepository
            .findByStockRecordIdAndConsumedDateBetween(stockRecordId, startDate, LocalDate.now());
        
        double totalConsumed = logs.stream()
            .mapToInt(ConsumptionLog::getConsumedQuantity)
            .sum();
        
        double avgDailyConsumption = totalConsumed / rule.getAverageDaysWindow();
        
        // Apply min/max bounds
        if (avgDailyConsumption < rule.getMinDailyUsage()) {
            avgDailyConsumption = rule.getMinDailyUsage();
        }
        if (avgDailyConsumption > rule.getMaxDailyUsage()) {
            avgDailyConsumption = rule.getMaxDailyUsage();
        }
        
        if (avgDailyConsumption <= 0) {
            avgDailyConsumption = 1; // Prevent division by zero
        }
        
        // Calculate days until reorder threshold
        int daysUntilReorder = (int) Math.ceil(
            (stockRecord.getCurrentQuantity() - stockRecord.getReorderThreshold()) / avgDailyConsumption
        );
        
        return LocalDate.now().plusDays(Math.max(1, daysUntilReorder));
    }
}
package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.PredictionRule;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PredictionServiceImpl implements PredictionService {

    private final StockRecordRepository stockRecordRepository;
    private final ConsumptionLogRepository consumptionLogRepository;
    private final PredictionRuleRepository predictionRuleRepository;

    @Override
    @Transactional(readOnly = true)
    public LocalDate predictRestockDate(Long stockRecordId) {
        StockRecord stockRecord = stockRecordRepository.findById(stockRecordId)
            .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found"));
        
        // Get the default prediction rule (first one)
        List<PredictionRule> rules = predictionRuleRepository.findAll();
        if (rules.isEmpty()) {
            throw new ResourceNotFoundException("No prediction rules found");
        }
        
        PredictionRule rule = rules.get(0);
        
        // Calculate average daily consumption
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(rule.getAverageDaysWindow());
        
        List<ConsumptionLog> logs = consumptionLogRepository
            .findByStockRecordIdAndConsumedDateBetween(stockRecordId, startDate, endDate);
        
        if (logs.isEmpty()) {
            return LocalDate.now().plusDays(30); // Default 30 days if no consumption data
        }
        
        int totalConsumption = logs.stream()
            .mapToInt(ConsumptionLog::getConsumedQuantity)
            .sum();
        
        double averageDailyConsumption = (double) totalConsumption / rule.getAverageDaysWindow();
        
        // Adjust based on min/max daily usage
        averageDailyConsumption = Math.max(rule.getMinDailyUsage(), 
            Math.min(rule.getMaxDailyUsage(), averageDailyConsumption));
        
        if (averageDailyConsumption <= 0) {
            return LocalDate.now().plusDays(30);
        }
        
        // Calculate days until reorder threshold
        int quantityToThreshold = stockRecord.getCurrentQuantity() - stockRecord.getReorderThreshold();
        int daysToReorder = (int) Math.ceil(quantityToThreshold / averageDailyConsumption);
        
        return LocalDate.now().plusDays(daysToReorder);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }

    @Override
    public PredictionRule createRule(PredictionRule rule) {
        if (rule.getAverageDaysWindow() == null || rule.getAverageDaysWindow() <= 0) {
            throw new IllegalArgumentException("Average days window must be greater than zero");
        }
        
        if (rule.getMinDailyUsage() > rule.getMaxDailyUsage()) {
            throw new IllegalArgumentException("Min daily usage must be less than or equal to max daily usage");
        }
        
        predictionRuleRepository.findByRuleName(rule.getRuleName())
            .ifPresent(r -> {
                throw new IllegalArgumentException("Rule name must be unique");
            });
        
        return predictionRuleRepository.save(rule);
    }
}
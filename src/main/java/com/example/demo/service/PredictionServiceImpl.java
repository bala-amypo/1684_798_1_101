package com.example.demo.service;

import com.example.demo.model.PredictionRule;
import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PredictionServiceImpl implements PredictionService {
    private final PredictionRuleRepository predictionRuleRepository;
    private final ConsumptionLogRepository consumptionLogRepository;
    private final StockRecordRepository stockRecordRepository;
    
    @Override
    @Transactional
    public PredictionRule createRule(PredictionRule rule) {
        return predictionRuleRepository.save(rule);
    }
    
    @Override
    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }
    
    @Override
    public LocalDate predictRestockDate(Long stockRecordId) {
        StockRecord stockRecord = stockRecordRepository.findById(stockRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found with id: " + stockRecordId));
        
        // Get consumption logs for last 30 days
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(30);
        
        List<ConsumptionLog> logs = consumptionLogRepository
                .findByStockRecordIdAndConsumedDateBetween(stockRecordId, startDate, endDate);
        
        if (logs.isEmpty()) {
            // Fallback: use default rule
            Optional<PredictionRule> defaultRule = predictionRuleRepository.findByRuleName("default");
            int avgDaily = defaultRule.map(PredictionRule::getMinDailyUsage).orElse(1);
            int days = stockRecord.getCurrentQuantity() / avgDaily;
            return LocalDate.now().plusDays(Math.max(1, days));
        }
        
        // Calculate average daily consumption
        double totalConsumed = logs.stream()
                .mapToInt(ConsumptionLog::getConsumedQuantity)
                .sum();
        long days = logs.stream()
                .map(ConsumptionLog::getConsumedDate)
                .distinct()
                .count();
        
        double avgDaily = days > 0 ? totalConsumed / days : 1;
        
        // Apply prediction rules
        Optional<PredictionRule> rule = predictionRuleRepository.findTopByOrderByIdDesc();
        if (rule.isPresent()) {
            PredictionRule r = rule.get();
            avgDaily = Math.max(r.getMinDailyUsage(), Math.min(r.getMaxDailyUsage(), avgDaily));
        }
        
        int daysToDepletion = (int) Math.ceil(stockRecord.getCurrentQuantity() / avgDaily);
        return LocalDate.now().plusDays(Math.max(1, daysToDepletion));
    }
}
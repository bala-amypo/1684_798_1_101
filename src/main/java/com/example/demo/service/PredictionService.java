package com.example.demo.service;

import com.example.demo.model.PredictionRule;
import java.util.List;

public interface PredictionService {

    String predictRestockDate(Long productId);

    PredictionRule createRule(PredictionRule rule);

    List<PredictionRule> getAllRules();
}

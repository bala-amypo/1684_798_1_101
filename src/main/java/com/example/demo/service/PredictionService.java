package com.example.demo.service;

import com.example.demo.model.PredictionRule;
import java.time.LocalDate;
import java.util.List;

public interface PredictionService {
    List<PredictionRule> predict(LocalDate date);
}

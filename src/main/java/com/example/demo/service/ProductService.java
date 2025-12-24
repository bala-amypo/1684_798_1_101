package com.example.demo.service;

public interface PredictionService {
    int predictStockOutDays(Long stockRecordId);
    double calculateAverageDailyConsumption(Long stockRecordId, int days);
    boolean isStockCritical(Long stockRecordId);
    int calculateReorderQuantity(Long stockRecordId);
}
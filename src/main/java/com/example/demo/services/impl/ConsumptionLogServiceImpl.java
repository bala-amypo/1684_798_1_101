// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.ConsumptionLog;
// import com.example.demo.model.StockRecord;
// import com.example.demo.repository.ConsumptionLogRepository;
// import com.example.demo.repository.StockRecordRepository;
// import com.example.demo.service.ConsumptionLogService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.time.LocalDate;
// import java.util.List;

// @Service
// @RequiredArgsConstructor
// @Transactional
// public class ConsumptionLogServiceImpl implements ConsumptionLogService {

//     private final ConsumptionLogRepository consumptionLogRepository;
//     private final StockRecordRepository stockRecordRepository;

//     @Override
//     public ConsumptionLog logConsumption(Long stockRecordId, ConsumptionLog log) {
//         StockRecord stockRecord = stockRecordRepository.findById(stockRecordId)
//             .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found"));
        
//         if (log.getConsumedQuantity() == null || log.getConsumedQuantity() <= 0) {
//             throw new IllegalArgumentException("Consumed quantity must be greater than zero");
//         }
        
//         if (log.getConsumedDate() == null || log.getConsumedDate().isAfter(LocalDate.now())) {
//             throw new IllegalArgumentException("consumedDate cannot be future");
//         }
        
//         log.setStockRecord(stockRecord);
        
//         // Update stock record quantity
//         stockRecord.setCurrentQuantity(
//             stockRecord.getCurrentQuantity() - log.getConsumedQuantity()
//         );
//         stockRecord.setLastUpdated(java.time.LocalDateTime.now());
//         stockRecordRepository.save(stockRecord);
        
//         return consumptionLogRepository.save(log);
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public List<ConsumptionLog> getLogsByStockRecord(Long stockRecordId) {
//         return consumptionLogRepository.findByStockRecordId(stockRecordId);
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public ConsumptionLog getLog(Long id) {
//         return consumptionLogRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("ConsumptionLog not found"));
//     }
// }
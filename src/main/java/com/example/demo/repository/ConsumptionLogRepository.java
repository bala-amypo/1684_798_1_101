package com.example.demo.repository;

import com.example.demo.model.ConsumptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {
    List<ConsumptionLog> findByStockRecordId(Long stockRecordId);
    
    // Add method that test expects
    List<ConsumptionLog> findByStockRecordIdOrderByConsumedDateDesc(Long stockRecordId);
    
    List<ConsumptionLog> findByStockRecordIdAndConsumedDateBetween(
        Long stockRecordId, 
        java.time.LocalDate startDate, 
        java.time.LocalDate endDate
    );
}
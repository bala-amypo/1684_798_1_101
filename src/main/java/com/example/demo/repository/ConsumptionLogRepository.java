package com.example.demo.repository;

import com.example.demo.model.ConsumptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {
    List<ConsumptionLog> findByStockRecordIdAndConsumedDateBetween(Long stockRecordId, LocalDate startDate, LocalDate endDate);
    List<ConsumptionLog> findByStockRecordId(Long stockRecordId); // Add this method
}
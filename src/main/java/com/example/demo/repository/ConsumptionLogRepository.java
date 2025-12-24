package com.example.demo.repository;

import com.example.demo.model.ConsumptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {
    List<ConsumptionLog> findByStockRecordId(Long stockRecordId);
    
    List<ConsumptionLog> findByStockRecordIdAndConsumedDateBetween(
        Long stockRecordId, 
        LocalDate startDate, 
        LocalDate endDate
    );
    
    List<ConsumptionLog> findByStockRecordIdOrderByConsumedDateDesc(Long stockRecordId);
    
    // HQL/JPQL example for advanced querying
    // @Query("SELECT cl FROM ConsumptionLog cl WHERE cl.stockRecord.product.id = :productId AND cl.consumedDate >= :startDate")
    // List<ConsumptionLog> findByProductIdAndDate(@Param("productId") Long productId, @Param("startDate") LocalDate startDate);
    
    // Native SQL query example
    // @Query(value = "SELECT * FROM consumption_logs WHERE stock_record_id = :recordId AND consumed_quantity > :minQuantity", nativeQuery = true)
    // List<ConsumptionLog> findHighConsumptionLogs(@Param("recordId") Long recordId, @Param("minQuantity") Integer minQuantity);
}
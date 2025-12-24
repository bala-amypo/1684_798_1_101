package com.example.demo.repository;

import com.example.demo.model.StockRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRecordRepository extends JpaRepository<StockRecord, Long> {
    List<StockRecord> findByProductId(Long productId);
    Optional<StockRecord> findByProductIdAndWarehouseId(Long productId, Long warehouseId);
    
    // Custom query method for HQL/JPQL if needed
    // @Query("SELECT sr FROM StockRecord sr WHERE sr.product.id = :productId AND sr.currentQuantity < sr.reorderThreshold")
    // List<StockRecord> findLowStockRecords(@Param("productId") Long productId);
}
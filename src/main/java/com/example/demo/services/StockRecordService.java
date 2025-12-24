package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockRecordService {
    private final StockRecordRepository stockRecordRepository;
    private final ProductService productService;
    private final WarehouseService warehouseService;
    
    public StockRecord createStockRecord(Long productId, Long warehouseId, StockRecord stockRecord) {
        // Check if stock record already exists
        if (stockRecordRepository.findByProductIdAndWarehouseId(productId, warehouseId).isPresent()) {
            throw new IllegalArgumentException("StockRecord already exists for this product-warehouse pair");
        }
        
        Product product = productService.getProduct(productId);
        Warehouse warehouse = warehouseService.getWarehouse(warehouseId);
        
        stockRecord.setProduct(product);
        stockRecord.setWarehouse(warehouse);
        
        return stockRecordRepository.save(stockRecord);
    }
    
    public StockRecord getStockRecord(Long id) {
        return stockRecordRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found"));
    }
    
    public List<StockRecord> getRecordsBy_product(Long productId) {
        return stockRecordRepository.findByProductId(productId);
    }
    
    public StockRecord updateStockQuantity(Long id, Integer quantity) {
        StockRecord stockRecord = getStockRecord(id);
        stockRecord.setCurrentQuantity(quantity);
        return stockRecordRepository.save(stockRecord);
    }
}
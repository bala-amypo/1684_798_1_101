package com.example.demo.service;

import com.example.demo.model.StockRecord;
import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.WarehouseRepository;
import com.example.demo.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StockRecordServiceImpl implements StockRecordService {
    private final StockRecordRepository stockRecordRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    
    @Override
    public StockRecord createStockRecord(Long productId, Long warehouseId, StockRecord stockRecord) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found with id: " + warehouseId));
        
        // Check if stock record already exists
        stockRecordRepository.findByProductIdAndWarehouseId(productId, warehouseId)
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("StockRecord already exists for this product and warehouse");
                });
        
        stockRecord.setProduct(product);
        stockRecord.setWarehouse(warehouse);
        return stockRecordRepository.save(stockRecord);
    }
    
    @Override
    public StockRecord getStockRecord(Long id) {
        return stockRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found with id: " + id));
    }
    
    @Override
    public List<StockRecord> getRecordsBy_product(Long productId) {
        return stockRecordRepository.findByProductId(productId);
    }
}
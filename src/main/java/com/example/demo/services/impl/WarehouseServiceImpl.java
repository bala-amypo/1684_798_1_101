// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.Warehouse;
// import com.example.demo.repository.WarehouseRepository;
// import com.example.demo.service.WarehouseService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;

// @Service
// @RequiredArgsConstructor
// @Transactional
// public class WarehouseServiceImpl implements WarehouseService {

//     private final WarehouseRepository warehouseRepository;

//     @Override
//     public Warehouse createWarehouse(Warehouse warehouse) {
//         if (warehouse.getLocation() == null || warehouse.getLocation().trim().isEmpty()) {
//             throw new IllegalArgumentException("Location must not be empty");
//         }
        
//         warehouseRepository.findByWarehouseName(warehouse.getWarehouseName())
//             .ifPresent(w -> {
//                 throw new IllegalArgumentException("Warehouse name must be unique");
//             });
        
//         return warehouseRepository.save(warehouse);
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public Warehouse getWarehouse(Long id) {
//         return warehouseRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public List<Warehouse> getAllWarehouses() {
//         return warehouseRepository.findAll();
//     }
// }
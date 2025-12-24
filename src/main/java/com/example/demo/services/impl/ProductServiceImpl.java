// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.Product;
// import com.example.demo.repository.ProductRepository;
// import com.example.demo.service.ProductService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;

// @Service
// @RequiredArgsConstructor
// @Transactional
// public class ProductServiceImpl implements ProductService {

//     private final ProductRepository productRepository;

//     @Override
//     public Product createProduct(Product product) {
//         if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
//             throw new IllegalArgumentException("Product name must not be empty");
//         }
        
//         productRepository.findBySku(product.getSku())
//             .ifPresent(p -> {
//                 throw new IllegalArgumentException("SKU must be unique");
//             });
        
//         return productRepository.save(product);
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public Product getProduct(Long id) {
//         return productRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public List<Product> getAllProducts() {
//         return productRepository.findAll();
//     }
// }
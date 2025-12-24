package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product getProduct(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product updateProduct(Long id, Product product) {
        Product existing = getProduct(id);
        existing.setProductName(product.getProductName());
        existing.setSku(product.getSku());
        existing.setCategory(product.getCategory());
        return productRepository.save(existing);
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
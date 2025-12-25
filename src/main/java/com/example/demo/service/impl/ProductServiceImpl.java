package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product save(Product product) {
        return product;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Product findById(Long id) {
        return new Product();
    }
}

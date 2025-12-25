package com.example.demo.service;

import com.example.demo.model.Product;
import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);
}

package com.example.demo;

import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    
    @Test
    void testProductCreation() {
        Product product = Product.builder()
            .name("Test Product")
            .description("Test Description")
            .category("Test Category")
            .build();
        
        assertNotNull(product);
        assertEquals("Test Product", product.getName());
        assertEquals("Test Description", product.getDescription());
        assertEquals("Test Category", product.getCategory());
    }
    
    @Test
    void testProductSetters() {
        Product product = new Product();
        product.setName("Product A");
        product.setDescription("Description A");
        product.setCategory("Category A");
        
        assertEquals("Product A", product.getName());
        assertEquals("Description A", product.getDescription());
        assertEquals("Category A", product.getCategory());
    }
}
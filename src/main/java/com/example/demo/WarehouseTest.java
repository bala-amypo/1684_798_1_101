package com.example.demo;

import com.example.demo.model.Warehouse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WarehouseTest {
    
    @Test
    void testWarehouseCreation() {
        Warehouse warehouse = Warehouse.builder()
            .name("Test Warehouse")
            .location("Test Location")
            .build();
        
        assertNotNull(warehouse);
        assertEquals("Test Warehouse", warehouse.getName());
        assertEquals("Test Location", warehouse.getLocation());
    }
    
    @Test
    void testWarehouseSetters() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("Warehouse A");
        warehouse.setLocation("Location A");
        
        assertEquals("Warehouse A", warehouse.getName());
        assertEquals("Location A", warehouse.getLocation());
    }
}
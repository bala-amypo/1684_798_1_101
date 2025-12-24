package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.List;

@SpringBootTest
@Listeners(TestResultListener.class)
public class InventoryApplicationTests extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private WarehouseService warehouseService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private StockRecordService stockRecordService;
    
    @Autowired
    private ConsumptionLogService consumptionLogService;
    
    @Autowired
    private PredictionService predictionService;
    
    @BeforeClass
    public void setup() {
        // Setup code if needed
    }
    
    @Test
    public void testWarehouseCreation() {
        Warehouse warehouse = Warehouse.builder()
                .name("Test Warehouse 1")
                .location("Location 1")
                .build();
        
        Warehouse saved = warehouseService.createWarehouse(warehouse);
        Assert.assertNotNull(saved);
        Assert.assertNotNull(saved.getId());
        Assert.assertEquals(saved.getName(), "Test Warehouse 1");
    }
    
    @Test
    public void testGetWarehouse() {
        Warehouse warehouse = Warehouse.builder()
                .name("Test Warehouse 2")
                .location("Location 2")
                .build();
        
        Warehouse saved = warehouseService.createWarehouse(warehouse);
        Warehouse retrieved = warehouseService.getWarehouse(saved.getId());
        Assert.assertNotNull(retrieved);
        Assert.assertEquals(retrieved.getName(), "Test Warehouse 2");
    }
    
    // Add the rest of your test methods with corrected method calls...
}
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InventoryApplicationTests {
    
    @Test
    public void contextLoads() {
        assertTrue(true);
    }
    
    @Test
    public void basicTest() {
        assertTrue(1 + 1 == 2);
    }
}
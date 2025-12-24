package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);
    }

    @Test
    void testBasicMath() {
        assertEquals(4, 2 + 2);
        assertNotEquals(5, 2 + 2);
    }

    @Test
    void testStrings() {
        String test = "Hello World";
        assertEquals("Hello World", test);
        assertTrue(test.contains("World"));
    }

    @Test
    void testBooleans() {
        assertTrue(10 > 5);
        assertFalse(5 > 10);
    }

    @Test
    void testNull() {
        String nullString = null;
        String notNullString = "test";
        
        assertNull(nullString);
        assertNotNull(notNullString);
    }
}
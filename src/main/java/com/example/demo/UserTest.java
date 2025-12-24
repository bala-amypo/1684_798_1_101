package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {
    
    @Test
    void testUserCreation() {
        User user = User.builder()
            .email("test@example.com")
            .password("password123")
            .roles("USER")
            .build();
        
        assertNotNull(user);
        assertEquals("test@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("USER", user.getRoles());
    }
}
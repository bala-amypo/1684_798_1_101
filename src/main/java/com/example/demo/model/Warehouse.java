package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String location;
    
    // Custom builder method if needed by tests
    public static WarehouseBuilder builder() {
        return new WarehouseBuilder();
    }
    
    // Builder class with proper methods
    public static class WarehouseBuilder {
        private Long id;
        private String name;
        private String location;
        
        public WarehouseBuilder id(Long id) {
            this.id = id;
            return this;
        }
        
        public WarehouseBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        // Alias method for tests using warehouseName()
        public WarehouseBuilder warehouseName(String name) {
            this.name = name;
            return this;
        }
        
        public WarehouseBuilder location(String location) {
            this.location = location;
            return this;
        }
        
        public Warehouse build() {
            return new Warehouse(id, name, location);
        }
    }
}
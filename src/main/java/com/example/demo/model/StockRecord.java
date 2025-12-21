package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "stock_records")
public class StockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer currentQuantity;

    private Integer reorderThreshold;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Warehouse warehouse;

    private LocalDateTime lastUpdated;
}

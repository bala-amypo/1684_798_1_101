package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "warehouse_id"})
)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Warehouse warehouse;

    private Integer currentQuantity;

    private Integer reorderThreshold;

    private LocalDateTime lastUpdated;
}

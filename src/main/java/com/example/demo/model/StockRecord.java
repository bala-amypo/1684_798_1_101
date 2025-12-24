// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "stock_records", uniqueConstraints = {
//     @UniqueConstraint(columnNames = {"product_id", "warehouse_id"})
// })
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class StockRecord {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "product_id", nullable = false)
//     private Product product;
    
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "warehouse_id", nullable = false)
//     private Warehouse warehouse;
    
//     @Column(nullable = false)
//     @Builder.Default
//     private Integer currentQuantity = 0;
    
//     @Column(nullable = false)
//     private Integer reorderThreshold;
    
//     @Column(nullable = false)
//     @Builder.Default
//     private LocalDateTime lastUpdated = LocalDateTime.now();
// }
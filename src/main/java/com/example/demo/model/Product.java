// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "products", uniqueConstraints = {
//     @UniqueConstraint(columnNames = "sku")
// })
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Product {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @Column(nullable = false)
//     private String productName;
    
//     @Column(unique = true, nullable = false)
//     private String sku;
    
//     private String category;
    
//     @Column(nullable = false)
//     @Builder.Default
//     private LocalDateTime createdAt = LocalDateTime.now();
// }
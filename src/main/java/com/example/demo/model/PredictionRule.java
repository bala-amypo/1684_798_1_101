package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "ruleName"))
public class PredictionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private Integer averageDaysWindow;
    private Integer minDailyUsage;
    private Integer maxDailyUsage;
    private LocalDateTime createdAt;
}

package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prediction_rules")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PredictionRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "rule_name", nullable = false)
    private String ruleName;
    
    @Column(name = "average_days_window")
    private Integer averageDaysWindow;
    
    @Column(name = "min_daily_usage")
    private Integer minDailyUsage;
    
    @Column(name = "max_daily_usage")
    private Integer maxDailyUsage;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
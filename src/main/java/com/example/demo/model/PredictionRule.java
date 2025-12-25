package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PredictionRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int averageDaysWindow;
    private int minDailyUsage;
    private int maxDailyUsage;
}

package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConsumptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int consumedQuantity;
    private LocalDate consumedDate;

    @ManyToOne
    private StockRecord stockRecord;
}

package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "consumption_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "stock_record_id", nullable = false)
    private StockRecord stockRecord;
    
    @Column(name = "consumed_quantity", nullable = false)
    private Integer consumedQuantity;
    
    @Column(name = "consumed_date", nullable = false)
    private LocalDate consumedDate;
}
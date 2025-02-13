package com.example.pos_api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "refunds")
public class RefundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime refundDate;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "sale_item_id", nullable = true) // Nullable for full-sale refunds
    private SaleItemsEntity saleItem;

    private Integer refundedQuantity;
    private Double refundedAmount;

    private String refundReason;

}

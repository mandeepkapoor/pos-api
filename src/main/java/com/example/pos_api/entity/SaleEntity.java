package com.example.pos_api.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales") //This will contain sales for the day, to see what it include look into saleitem to see what items each sale has
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime saleDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true) // Optional customer for loyalty tracking
    private CustomerEntity customer;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItemsEntity> saleItems;

    private Double totalAmount;
    private Double cashPaid;
    private Double cardPaid;

    private String paymentMethod; // Cash, Card, Both

}

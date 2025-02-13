package com.example.pos_api.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sale_items") //This table will contain the list of items included in a sale
public class SaleItemsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private SaleEntity sale;

    @ManyToOne
    @JoinColumn(name = "stock_item_id", nullable = false)
    private StockItem stockItem;

    private Integer quantity;
    private Double pricePerItem;
    private Double totalPrice;

    private boolean refunded = false; // Tracks if the item has been refunded
}

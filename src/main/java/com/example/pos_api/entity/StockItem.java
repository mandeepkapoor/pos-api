package com.example.pos_api.entity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Use JOINED inheritance strategy
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // Use type name to resolve the type
        include = JsonTypeInfo.As.PROPERTY, // Include type info as a property
        property = "type" // The property name to hold the type information
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Phone.class, name = "Phone"),
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock_items")
public abstract class StockItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Common name for all stock items
    private Double cost;
    private Integer quantity;
    private String colour;
    private String description;
    private Date purchaseDate;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false) // Foreign key to supplier
    private SupplierEntity supplier;  // Supplier associated with the stock item
}

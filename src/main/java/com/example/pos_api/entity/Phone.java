package com.example.pos_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phones")
public class Phone extends StockItem{

    private String brand;  // Brand of the phone (e.g., Apple, Samsung)
    private String model;  // Model of the phone
    private String operatingSystem;  // OS (e.g., iOS, Android)
    private Integer storageCapacity;  // Storage capacity (e.g., 128GB, 256GB)
    private String availabilityStatus; //Sold, returned to warehouse, refunded

    @Column(unique = true)
    private String imei;  // IMEI number, unique for each phone
}

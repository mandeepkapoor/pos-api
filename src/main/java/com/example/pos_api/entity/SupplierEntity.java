package com.example.pos_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suppliers")  // Specifies the table name in the DB
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String name;
    private String email;
    private String phone;
    private String companyName;
    private Long VATNUMBER;

    private String postcode;
    private String addressLine1;
    private String addressLine2;


}

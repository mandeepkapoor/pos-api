package com.example.pos_api.controller;


import com.example.pos_api.Interface.SupplierServiceInterface;
import com.example.pos_api.entity.SupplierEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierServiceInterface supplierService;

    // POST: Create a Supplier
    @PostMapping("/create")
    public ResponseEntity<SupplierEntity> createSupplier(@RequestBody SupplierEntity supplier) {
        // Save the supplier using the service
        SupplierEntity savedSupplier = supplierService.saveSupplier(supplier);
        // Return the saved supplier as the response
        return ResponseEntity.ok(savedSupplier);
    }

    @GetMapping("/list")
    public ResponseEntity<List<SupplierEntity>> getAllSuppliers() {
        List<SupplierEntity> supplier = supplierService.getAllSuppliers();
        return ResponseEntity.ok(supplier);
    }

    // PUT: Update an existing Supplier
    @PutMapping("/update/{id}")
    public ResponseEntity<SupplierEntity> updateSupplier(@PathVariable Long id, @RequestBody SupplierEntity updatedSupplier) {

        // Update the supplier using the service
        SupplierEntity updated = supplierService.updateSupplier(id, updatedSupplier);
        // Return the updated supplier as the response
        return ResponseEntity.ok(updated);
    }
}

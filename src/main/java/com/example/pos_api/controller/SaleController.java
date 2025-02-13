package com.example.pos_api.controller;
import com.example.pos_api.entity.SaleEntity;
import com.example.pos_api.service.SaleService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @PostMapping("/create")
    public ResponseEntity<SaleEntity> createSale(@RequestBody SaleEntity sale) {
        return ResponseEntity.ok(saleService.createSale(sale));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleEntity> getSale(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

}

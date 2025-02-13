package com.example.pos_api.service;

import com.example.pos_api.Repository.SaleRepository;
import com.example.pos_api.entity.SaleEntity;
import com.example.pos_api.entity.SaleItemsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleEntity createSale(SaleEntity sale) {
        sale.setSaleDate(LocalDateTime.now());

        double totalAmount = sale.getSaleItems().stream()
                .mapToDouble(SaleItemsEntity::getTotalPrice)
                .sum();
        sale.setTotalAmount(totalAmount);

        return saleRepository.save(sale);
    }

    public SaleEntity getSaleById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
    }
}

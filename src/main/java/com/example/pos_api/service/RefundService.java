package com.example.pos_api.service;

import com.example.pos_api.Repository.RefundRepository;
import com.example.pos_api.Repository.SaleRepository;
import com.example.pos_api.entity.RefundEntity;
import com.example.pos_api.entity.SaleEntity;
import com.example.pos_api.entity.SaleItemsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RefundService {

    private final RefundRepository refundRepository;
    private final SaleRepository saleRepository;

    public RefundEntity processRefund(Long saleId, Long saleItemId, int quantity, String reason) {
        // Fetch the sale entity
        SaleEntity sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        // Find the specific item in the sale
        SaleItemsEntity saleItem = sale.getSaleItems().stream()
                .filter(item -> item.getId().equals(saleItemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Sale item not found in the sale"));

        // Check if the item has already been refunded
        if (saleItem.isRefunded()) {
            throw new RuntimeException("This item has already been refunded");
        }

        // Create refund entity
        RefundEntity refund = new RefundEntity();
        refund.setRefundDate(LocalDateTime.now());
        refund.setSale(sale);
        refund.setSaleItem(saleItem);
        refund.setRefundedQuantity(quantity);
        refund.setRefundedAmount(saleItem.getPricePerItem() * quantity);
        refund.setRefundReason(reason);

        // Mark item as refunded
        saleItem.setRefunded(true);

        // Save sale entity since saleItems are part of sale
        saleRepository.save(sale);

        return refundRepository.save(refund);
    }

    public RefundEntity refundFullSale(Long saleId, String reason) {
        SaleEntity sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        RefundEntity refund = new RefundEntity();
        refund.setRefundDate(LocalDateTime.now());
        refund.setSale(sale);
        refund.setRefundedAmount(sale.getTotalAmount());
        refund.setRefundReason(reason);

        sale.getSaleItems().forEach(item -> item.setRefunded(true));

        return refundRepository.save(refund);
    }
}

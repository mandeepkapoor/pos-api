package com.example.pos_api.service;

import com.example.pos_api.Repository.StockItemRepository;
import com.example.pos_api.entity.StockItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockItemService {

    private final StockItemRepository stockItemRepository;
    public StockItem save(StockItem stockItem) {
        return stockItemRepository.save(stockItem);
    }

    public List<StockItem> findAll() {
        return stockItemRepository.findAll();
    }
}

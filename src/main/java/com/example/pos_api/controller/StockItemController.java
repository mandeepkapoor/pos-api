package com.example.pos_api.controller;


import com.example.pos_api.entity.StockItem;
import com.example.pos_api.service.StockItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stock")
@RequiredArgsConstructor
public class StockItemController {

    private final StockItemService stockItemService;

    @PostMapping("/create")
    public ResponseEntity<StockItem> createStockItem(@RequestBody StockItem stockItem) {
        try {
            StockItem createdStockItem = stockItemService.save(stockItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStockItem);
        } catch (HttpMessageNotReadableException e) {
            // Handle the error gracefully and return an appropriate response
            return (ResponseEntity<StockItem>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public List<StockItem> list() {
        return stockItemService.findAll();
    }
}

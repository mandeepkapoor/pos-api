package com.example.pos_api.Repository;

import com.example.pos_api.entity.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Long> {
    // Custom queries for stock items can go here, for example:
    List<StockItem> findByName(String name);
}

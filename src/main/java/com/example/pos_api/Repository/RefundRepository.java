package com.example.pos_api.Repository;

import com.example.pos_api.entity.RefundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefundRepository extends JpaRepository<RefundEntity, Long> {
}

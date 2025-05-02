package com.training.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

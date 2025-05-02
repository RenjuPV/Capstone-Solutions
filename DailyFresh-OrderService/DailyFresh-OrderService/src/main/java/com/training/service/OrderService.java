package com.training.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.OrderRepository;
import com.training.model.Order;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setOrderDate(LocalDate.now());
        order.getOrderItems().forEach(item -> item.setOrder(order));
        double total = order.getOrderItems().stream()
                            .mapToDouble(item -> item.getPrice() * item.getQuantity())
                            .sum();
        order.setOrderAmount(total);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
}

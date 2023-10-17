package com.andreirosca.gamesstoreapi.service;


import com.andreirosca.gamesstoreapi.model.Order;
import com.andreirosca.gamesstoreapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;
    public Order addOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll(Sort.by("orderDate"));
    }

    public Order getOrder(UUID id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Order with id = " + id));
    }
}

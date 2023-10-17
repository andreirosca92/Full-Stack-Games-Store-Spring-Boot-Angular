package com.andreirosca.gamesstoreapi.service;


import com.andreirosca.gamesstoreapi.model.OrderItem;
import com.andreirosca.gamesstoreapi.repository.OrderItemRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository repository;


    public OrderItem createOrderItem(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return repository.findAll();
    }

    public OrderItem getOrderItem(UUID id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found OrderItem with id = " + id));
    }

    public void deleteOrderItem(UUID id) {
        repository.deleteById(id);
    }

    public OrderItem updateOrderItem(UUID id, OrderItem orderItem) {
        OrderItem orderItem1 = repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found OrderItem with id = " + id));
        orderItem1.setOrder(orderItem.getOrder());
        orderItem1.setGame(orderItem.getGame());
        orderItem1.setPrice(orderItem.getPrice());
        orderItem1.setQuantity(orderItem.getQuantity());

        return orderItem1;
    }
}

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

    public Order updateOrder(UUID id, Order order) {
        Order orderFound = repository.findById(id).orElseThrow(() -> new IllegalStateException("Not found Order with id = " + id));
        orderFound.setOrderDate(order.getOrderDate());
        orderFound.setOrderHistories(order.getOrderHistories());
        orderFound.setOrderitem(order.getOrderitem());
        orderFound.setAddress(order.getAddress());
        orderFound.setCustomer(order.getCustomer());
        orderFound.setTotal(order.getTotal());
        orderFound.setSubTotal(order.getSubTotal());
        orderFound.setShippingMethod(order.getShippingMethod());


        return  orderFound;
    }

    public void deleteOrder(UUID id) {
        repository.deleteById(id);
    }

    public void deleteAllOrders() {
        repository.deleteAll();
    }
}

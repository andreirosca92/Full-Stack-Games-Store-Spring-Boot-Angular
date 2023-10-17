package com.andreirosca.gamesstoreapi.controller;

import com.andreirosca.gamesstoreapi.model.OrderItem;
import com.andreirosca.gamesstoreapi.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class OrderItemController {

    @Autowired
    private OrderItemService service;
    @PostMapping("/orderitem")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem){
       OrderItem orderItem1 = service.createOrderItem(orderItem);

        return new ResponseEntity<>(orderItem1, HttpStatus.CREATED);
    }
    @GetMapping("/orderitem")
    public ResponseEntity<List<OrderItem>> getAllOrderItems(){
        List<OrderItem> orderItems = new ArrayList<>();

       orderItems = service.getAllOrderItems();
       if(orderItems.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }
    @GetMapping("/orderitem/{id}")
    public ResponseEntity<OrderItem> getOrderItem(@PathVariable("id")UUID id){
        OrderItem orderItem = service.getOrderItem(id);

        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }
    @DeleteMapping("/orderitem/{id}")
    public ResponseEntity<OrderItem> deleteOrderItem(@PathVariable("id") UUID id){
        service.deleteOrderItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/orderitem/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable("id") UUID id, @RequestBody OrderItem orderItem){
        OrderItem orderItem1 = service.updateOrderItem(id, orderItem);

        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

}

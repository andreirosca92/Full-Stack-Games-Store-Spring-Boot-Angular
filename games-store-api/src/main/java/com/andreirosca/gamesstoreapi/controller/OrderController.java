package com.andreirosca.gamesstoreapi.controller;


import com.andreirosca.gamesstoreapi.model.Game;
import com.andreirosca.gamesstoreapi.model.Order;
import com.andreirosca.gamesstoreapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping(path="/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        Order _order = service.addOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    @GetMapping(path= "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> _order = new ArrayList<>();
               _order= service.getAllOrders();
        if (_order.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(_order, HttpStatus.OK);

    }
    @GetMapping(path="/orders/{id}", consumes =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") UUID id){
        Order _order = service.getOrder(id);
        return new ResponseEntity<>(_order,  HttpStatus.OK);
    }
}

package com.andreirosca.gamesstoreapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="order_id")
    private UUID id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "subTotal")
    private double subTotal;



    @Column(name = "total")
    private  double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderitem;

    // One-to-Many
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderHistory> orderHistories;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "method_id", nullable = false)
    private ShippingMethod shippingMethod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

}

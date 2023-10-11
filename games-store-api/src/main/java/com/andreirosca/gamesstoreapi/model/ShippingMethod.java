package com.andreirosca.gamesstoreapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shipping_method")
public class ShippingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "method_id")
    private UUID id;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "cost")
    private double cost;

    //One-to-Many
    @OneToMany(mappedBy = "shippingMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders;


}

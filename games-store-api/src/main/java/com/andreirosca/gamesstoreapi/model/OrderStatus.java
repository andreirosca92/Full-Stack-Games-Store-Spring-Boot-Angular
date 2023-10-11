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
@Table(name="order_status")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="status_id")
    private UUID id;

    @Column(name = "status_value")
    private String statusValue;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderStatus", cascade = CascadeType.ALL)
    private Set<OrderHistory> orderHistories;
}

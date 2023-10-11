package com.andreirosca.gamesstoreapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_history")
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "history_id")
    private UUID id;

    @Column(name = "status_date")
    private LocalDate StatusDate;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;
}

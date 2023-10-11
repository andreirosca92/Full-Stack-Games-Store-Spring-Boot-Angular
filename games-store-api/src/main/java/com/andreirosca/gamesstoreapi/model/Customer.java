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
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="customer_id")
    private UUID id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "cell_phone")
    private String cellPhone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(mappedBy = "customer")
    Set<CustomerAddress> customerAddresses;

}

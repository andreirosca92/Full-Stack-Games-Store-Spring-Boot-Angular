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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="address_id")
    private UUID id;

    @Column(name="street_name")
    private String streetName;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name = "province")
    private String Province;



    @Column(name = "phone_number")
    private String phoneNumber;

//    @OneToOne(fetch = FetchType.EAGER)
//    @MapsId
//    @JoinColumn(name="customer_id")
//    private Customer customer;

    //One-to-Many
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;



    @OneToMany(mappedBy = "address")
    Set<CustomerAddress> customerAddresses;
}

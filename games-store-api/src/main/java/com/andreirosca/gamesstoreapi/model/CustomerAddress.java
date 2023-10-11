package com.andreirosca.gamesstoreapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_address")
public class CustomerAddress {
    @EmbeddedId
    CustomerAddressKey id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToOne
    @MapsId("addressId")
    @JoinColumn(name = "address_id")
    Address address;
    @ManyToOne
    @JoinColumn(name = "status_id")
    AddressStatus addressStatus;
}

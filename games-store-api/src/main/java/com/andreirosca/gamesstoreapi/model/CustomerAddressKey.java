package com.andreirosca.gamesstoreapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressKey implements Serializable {

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "address_id")
    private  UUID addressId;
}

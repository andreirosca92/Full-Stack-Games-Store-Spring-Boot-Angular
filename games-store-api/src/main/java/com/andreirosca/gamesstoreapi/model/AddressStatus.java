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
@Table(name="address_status")
public class AddressStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="status_id")
    private UUID id;

    @Column(name="address_status")
    private String addressStatus;

    @OneToMany(mappedBy = "addressStatus")
    Set<CustomerAddress> customerAddress;
}

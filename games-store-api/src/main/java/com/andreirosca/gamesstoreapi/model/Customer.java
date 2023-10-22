package com.andreirosca.gamesstoreapi.model;


import com.andreirosca.gamesstoreapi.model.user_account.UserAccount;
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
    @Column(name="customer_id")
    private UUID id;

    @Column(name="url")
    private String Url;

    @Column(name="pec")
    private String Pec;

    @Column(name="invoice")
    private boolean invoice;

    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name="tell_phone")
    private String tellPhone;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(mappedBy = "customer")
    Set<CustomerAddress> customerAddresses;

}

package com.andreirosca.gamesstoreapi.model.user_account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_access")
public class UserAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="AccessDate")
    private LocalDateTime AccessDate;

    @Column(name = "IsSucccessfulLogin")
    private boolean IsSuccessfulLogin;

    @Column(name="IPAdress")
    private String IPAdress;

    // Mapping the column of this table
    @ManyToOne
    //Adding the name
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

}

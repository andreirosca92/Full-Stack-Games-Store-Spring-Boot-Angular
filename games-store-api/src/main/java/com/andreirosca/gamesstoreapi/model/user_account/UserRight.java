package com.andreirosca.gamesstoreapi.model.user_account;

import jakarta.persistence.*;

@Entity
public class UserRight {

    @EmbeddedId
    private UserRightKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @ManyToOne
    @MapsId("rightId")
    @JoinColumn(name = "right_id")
    private Right right;

    @Column(name = "Suppress")
    private boolean Suppress;

}

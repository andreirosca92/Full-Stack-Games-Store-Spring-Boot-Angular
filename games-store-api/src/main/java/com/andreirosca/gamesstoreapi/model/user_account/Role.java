package com.andreirosca.gamesstoreapi.model.user_account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name="id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="IsActive")
    private boolean isActive;

    @ManyToMany(mappedBy = "roles")
    private Set<UserAccount> userAccount = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "RoleRight",
            joinColumns = { @JoinColumn(name = "role_id") },
            inverseJoinColumns = { @JoinColumn(name = "right_id") }
    )
    private Set<Right> rights = new HashSet<>();
}

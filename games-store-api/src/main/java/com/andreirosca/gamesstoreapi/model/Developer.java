package com.andreirosca.gamesstoreapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="developer_id")
    private UUID id;

    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;


    @ManyToMany(mappedBy = "developer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Game> games;





}

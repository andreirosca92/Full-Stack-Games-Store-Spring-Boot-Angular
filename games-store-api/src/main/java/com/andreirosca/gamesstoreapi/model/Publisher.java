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
@Table(name="publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="publisher_id")
    private UUID id;
    @Column(name="name")
    private String name;



    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Game> game;

}

package com.andreirosca.gamesstoreapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="games")
public class Game {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "game_id")
    private UUID id;
    @Column(name="name")
    public String name;

    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;
    @Enumerated(EnumType.STRING)
    @Column(name="platform")
    public Platform platform;
    @Column(name="rating")
    private double rating;
    @Column(name="link_img")
    private String image;
    @Column(name="date_released")
    private LocalDate released;

    @Column(name="price")
    private double price;


    @Column(name="condition")
    @Enumerated(EnumType.STRING)
    private Condition condition;

    //One-to-Many
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private Set<Developer> developer;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

     //One-to-One
    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Inventory inventory;

    // One-to-Many
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
    private Set<OrderItem> orderitem;
}

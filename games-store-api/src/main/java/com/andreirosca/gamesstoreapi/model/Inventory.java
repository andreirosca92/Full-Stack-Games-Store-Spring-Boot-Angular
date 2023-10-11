package com.andreirosca.gamesstoreapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="inventory_id")
    private UUID id;
    @Column(name="stock_level_used")
    private String StockLevelUsed;
    @Column(name = "stock_level_new")
    private String StockLevelNew;


    // One-to-One
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "game_id")
    private Game game;

}

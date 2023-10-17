package com.andreirosca.gamesstoreapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name="inventory")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="inventory_id")
    @JsonDeserialize(using = UUIDDeserializer.class)

    private UUID id;
    @Column(name="stock_level_used")
    @JsonProperty("stock_level_used")
    private String StockLevelUsed;
    @Column(name = "stock_level_new")
    @JsonProperty("stock_level_new")
    private String StockLevelNew;

    @JsonCreator
    public Inventory(String stockLevelUsed, String stockLevelNew, Game game) {

        StockLevelUsed = stockLevelUsed;
        StockLevelNew = stockLevelNew;
        this.game = game;
    }

    // One-to-One
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Game game;

}

package com.andreirosca.gamesstoreapi.model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@NoArgsConstructor
@Entity
@Table(name="inventory")

public class Inventory implements Serializable {

    private static final long serialVersionUID = 1003546783090023361L;

    @Id
    @Column(name = "id",unique = true, nullable = false)
    @JsonProperty("id")
    private UUID id;
    @Column(name="stock_level_used")
    @JsonProperty("sused")
    private String sused;
    @Column(name = "stock_level_new")
    @JsonProperty("snew")
    private String snew;



    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    @JsonProperty("game")
    @JsonIgnore
    private Game game;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSused(String sused) {
        this.sused = sused;
    }

    public void setSnew(String snew) {
        this.snew = snew;
    }

    public String getSused() {
        return sused;
    }

    public String getSnew() {
        return snew;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

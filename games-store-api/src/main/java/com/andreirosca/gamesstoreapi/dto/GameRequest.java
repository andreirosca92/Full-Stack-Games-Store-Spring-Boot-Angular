package com.andreirosca.gamesstoreapi.dto;

import com.andreirosca.gamesstoreapi.helpers.MyGenreDeserializer;
import com.andreirosca.gamesstoreapi.helpers.MyRequestModelDeserializer;
import com.andreirosca.gamesstoreapi.model.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.*;

@JsonDeserialize(using = MyRequestModelDeserializer.class)
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameRequest {





    public String name;


    private String description;

    @JsonDeserialize(using = MyGenreDeserializer.class)
    private Genre genre;

    public Platform platform;

    private double rating;

    private String image;

    private String released;

    private double price;

    private Condition condition;


    private PublisherRequest publisher;


    private InventoryRequest inventory;

    public GameRequest( String name, String description, Genre genre, Platform platform, double rating, String image, String released, double price, Condition condition, PublisherRequest publisher, InventoryRequest inventory) {

        this.name = name;
        this.description = description;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.image = image;
        this.released = released;
        this.price = price;
        this.condition = condition;
        this.publisher = publisher;
        this.inventory = inventory;
    }


    //    private Set<Developer> developer;
//    private Set<OrderItem> orderitem;



}

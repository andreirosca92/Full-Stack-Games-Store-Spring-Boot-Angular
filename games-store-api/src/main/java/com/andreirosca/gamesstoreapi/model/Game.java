package com.andreirosca.gamesstoreapi.model;

import com.andreirosca.gamesstoreapi.helpers.MyGameModel;
import com.andreirosca.gamesstoreapi.helpers.MyGenreDeserializer;
import com.andreirosca.gamesstoreapi.helpers.converter.ConditionAttributeConverter;
import com.andreirosca.gamesstoreapi.helpers.converter.GenreAttributeConverter;
import com.andreirosca.gamesstoreapi.helpers.converter.PlatformAttributeConverter;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jakarta.persistence.*;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

import java.util.Set;
import java.util.UUID;




@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="games")
public class Game {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "game_id")
    @JsonDeserialize(using = UUIDDeserializer.class)
    private UUID id;
    @Column(name="name")
    @JsonProperty("name")
    public String name;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    @JsonDeserialize(using = MyGenreDeserializer.class)
    @JsonProperty("genre")
    @Convert(converter = GenreAttributeConverter.class)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    @JsonProperty("platform")
    @Column(name="platform")
    @Convert(converter = PlatformAttributeConverter.class)
    public Platform platform;
    @JsonProperty("rating")
    @Column(name="rating")
    private double rating;
    @JsonProperty("image")
    @Column(name="link_img")
    private String image;
    @Column(name="date_released")
    @JsonProperty("released")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate released;

    @Column(name="price")
    @JsonProperty("price")
    private double price;


    @Column(name="condition")
    @Enumerated(EnumType.STRING)
    @JsonProperty("condition")
    @Convert(converter = ConditionAttributeConverter.class)
    private Condition condition;

    //One-to-Many
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    @JsonIgnore
    private Set<Developer> developer;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    @JsonProperty("publisher")
    private Publisher publisher;

     //One-to-One
    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @JsonProperty("inventory")
    private Inventory inventory;

    // One-to-Many
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<OrderItem> orderitem;


    public Game(String name, String description, Genre genre, Platform platform, double rating, String image, LocalDate released, double price, Condition condition, Set<Developer> developer, Publisher publisher, Inventory inventory, Set<OrderItem> orderitem) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.image = image;
        this.released = released;
        this.price = price;
        this.condition = condition;
        this.developer = developer;
        this.publisher = publisher;
        this.inventory = inventory;
        this.orderitem = orderitem;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Set<Developer> getDeveloper() {
        return developer;
    }

    public void setDeveloper(Set<Developer> developer) {
        this.developer = developer;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Set<OrderItem> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Set<OrderItem> orderitem) {
        this.orderitem = orderitem;
    }
}


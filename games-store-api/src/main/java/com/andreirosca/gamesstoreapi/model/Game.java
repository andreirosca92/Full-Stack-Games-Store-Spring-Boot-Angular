package com.andreirosca.gamesstoreapi.model;

import com.andreirosca.gamesstoreapi.helpers.*;
import com.andreirosca.gamesstoreapi.helpers.converter.ConditionAttributeConverter;
import com.andreirosca.gamesstoreapi.helpers.converter.GenreAttributeConverter;
import com.andreirosca.gamesstoreapi.helpers.converter.PlatformAttributeConverter;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

import java.util.Set;
import java.util.UUID;




@Data
@NoArgsConstructor
@Entity
@Table(name="games")
public class Game implements Serializable {

    private static final long serialVersionUID = 1003547683050029961L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false)
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
    @JsonDeserialize(using = MyPlatformDeserializer.class)
    public Platform platform;
    @JsonProperty("rating")
    @Column(name="rating")
    private double rating;
    @JsonProperty("image")
    @Column(name="link_img")
    private String image;

    @Column(name="date_released")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using= LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate released;

    @Column(name="price")
    @JsonProperty("price")
    private double price;


    @Column(name="condition")
    @Enumerated(EnumType.STRING)
    @JsonProperty("condition")
    @Convert(converter = ConditionAttributeConverter.class)
    @JsonDeserialize(using = MyConditionDeserializer.class)
    private Condition condition;

    //One-to-Many
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "game_developer",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    @JsonProperty("developer")
    private Set<Developer> developer;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    @JsonProperty("publisher")
    private Publisher publisher;

     //One-to-One
     @OneToOne(mappedBy = "game", cascade = CascadeType.ALL)
     @JsonProperty("inventory")
     private Inventory inventory;

    //  @JsonDeserialize(using = MyInventoryDeserializer.class)
    // One-to-Many
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
    @JsonProperty("orderitem")
    private Set<OrderItem> orderitem;



    @JsonCreator
    public Game(@JsonProperty("name") String name,@JsonProperty("description") String description,@JsonProperty("genre") Genre genre,@JsonProperty("platform") Platform platform,@JsonProperty("rating") double rating,@JsonProperty("image") String image,@JsonProperty("released") LocalDate released,@JsonProperty("price") double price,@JsonProperty("condition") Condition condition,@JsonProperty("developer") Set<Developer> developer, @JsonProperty("publisher") Publisher publisher,@JsonProperty("orderitem") Set<OrderItem> orderitem) {
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
        this.orderitem = orderitem;
    }

//    @JsonCreator
//    public static Game fromString(String id) {
//        return new Game(UUID.fromString(id));
//    }

    public Inventory getInventory() {
        return inventory;
    }
    public Game setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }

    @JsonSetter
    public void setInventoryId(UUID id) {

       this.inventory=new Inventory();
       this.inventory.setId(id);
       this.inventory.setGame(null);
       this.inventory.setSused("");
       this.inventory.setSnew("");

    }

    public UUID getId() {
        return id;
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





    public Set<OrderItem> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Set<OrderItem> orderitem) {
        this.orderitem = orderitem;
    }
}


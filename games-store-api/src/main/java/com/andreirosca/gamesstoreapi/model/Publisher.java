package com.andreirosca.gamesstoreapi.model;

import com.andreirosca.gamesstoreapi.helpers.MyGameModel;
import com.andreirosca.gamesstoreapi.helpers.MyPublisherModel;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;
import java.util.UUID;


@NoArgsConstructor
@Data
@Entity
@Table(name="publishers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="publisher_id")
    @JsonDeserialize(using = UUIDDeserializer.class)
    private UUID id;
    @Column(name="name")
    @JsonProperty("name")
    private String name;


    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Game> game;

    public Publisher(String name, Set<Game> game) {

        this.name = name;
        this.game = game;
    }
}

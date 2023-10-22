package com.andreirosca.gamesstoreapi.helpers;
import com.andreirosca.gamesstoreapi.dto.GameRequest;
import com.andreirosca.gamesstoreapi.dto.InventoryRequest;
import com.andreirosca.gamesstoreapi.dto.PublisherRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.andreirosca.gamesstoreapi.model.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;
import jakarta.persistence.criteria.CriteriaBuilder;


public class MyGameModel extends StdDeserializer<Game> {

    private static final long serialVersionUID = 1883547683050049861L;
    public MyGameModel() {
        this(null);
    }

    public MyGameModel(Class<?> vc) {
        super(vc);
    }

    @Override
    public Game deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);



        ObjectMapper mapper = new ObjectMapper();
        String nameGame = node.get("name").asText();
        String descGame = node.get("description").asText();
        Genre genre = Genre.valueOf(node.get("genre").asText());
        Platform platform = Platform.valueOf(node.get("platform").asText());
        Condition condition = Condition.valueOf(node.get("condition").asText());

        String namePublisher = node.get("publisher").get("name").asText();
        double rating  =node.get("rating").asDouble();
        double price = node.get("price").asDouble();
        String image = node.get("image").asText();

        ObjectMapper objectMapper = new ObjectMapper();

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate released =  LocalDate.parse(node.get("released").asText(),formatters);
        Set<Game> games = Collections.emptySet();
        Set<Developer> developers = Collections.emptySet();
        Set<OrderItem> orderItems = Collections.emptySet();



       return new Game(nameGame, descGame,genre, platform,rating, image, released, price, condition, developers, new Publisher(namePublisher, games),orderItems);
    }
}
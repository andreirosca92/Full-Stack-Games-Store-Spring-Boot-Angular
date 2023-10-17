package com.andreirosca.gamesstoreapi.helpers;
import com.andreirosca.gamesstoreapi.dto.GameRequest;
import com.andreirosca.gamesstoreapi.dto.InventoryRequest;
import com.andreirosca.gamesstoreapi.dto.PublisherRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.andreirosca.gamesstoreapi.model.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;


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
//        Genre genre = Genre.valueOf(node.get("genre").asText());
//        Platform platform = Platform.valueOf(node.get("platform").asText());
//        Condition condition = Condition.valueOf(node.get("condition").asText());
        //Inventory inventory =mapper.convertValue(node.get("inventory"), Inventory.class);
        String namePublisher = node.get("publisher").get("name").asText();
        double rating  =node.get("rating").asDouble();
        double price = node.get("price").asDouble();
        String image = node.get("image").asText();
//        String StockUsed = node.get("inventory").get("StockLevelUsed").asText();
//        String StockNew = node.get("inventory").get("StockLevelNew").asText();
//        LocalDate released =  node.get("released").asText();
        Set<Game> games = Collections.emptySet();
        Set<Developer> developers = Collections.emptySet();
        Set<OrderItem> orderItems = Collections.emptySet();


       return new Game(nameGame, descGame,null, null, rating, image,null, price, null, developers,new Publisher(namePublisher,  games),null,orderItems);

    }
}
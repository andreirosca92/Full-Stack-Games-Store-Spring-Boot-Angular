package com.andreirosca.gamesstoreapi.helpers;


import com.andreirosca.gamesstoreapi.model.Developer;
import com.andreirosca.gamesstoreapi.model.Game;
import com.andreirosca.gamesstoreapi.model.OrderItem;
import com.andreirosca.gamesstoreapi.model.Publisher;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MyPublisherModel extends StdDeserializer<Publisher> {
    private static final long serialVersionUID = 1823237683050049861L;

    public MyPublisherModel() {
        this(null);
    }

    public MyPublisherModel(Class<?> vc) {
        super(vc);
    }

    @Override
    public Publisher deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        //int gameId =(Integer) ((IntNode)node.get("id")).numberValue();
        //String name = node.get("name").asText();
        //String description = node.get("description").asText();
        //String image = node.get("image").asText();
        //double price = (Double) ((DoubleNode)node.get("price")).numberValue();
        //double rating  = (Double) ((DoubleNode)node.get("rating")).numberValue();
//      //  String action = node.get("genre").get("action").asText();
        // String platform = node.get("platform").asText();
//        LocalDate released =LocalDate.now();
        // String condition = node.get("condition").asText();
//        String developer = node.get("developer").asText();
//        String inventoryStockLevelNew = node.get("inventory").get("stockLevelNew").asText();
//        String inventoryStockLevelUsed = node.get("inventory").get("stockLevelUsed").asText();
        //int publisherId = (Integer) ((IntNode)node.get("publisher").get("id")).numberValue();
        //String publisherName= node.get("publisher").get("name").asText();


        //String publisherName = node.get("publisher").get("name").asText();
//        Platform platform = null;
//        Condition condition = null;
//        String inventoryStockLevelNew = "";
//        String inventoryStockLevelUsed = "";
//        Genre genre = null;
//        Set<Developer> developerSet = Collections.emptySet();
//        Set<OrderItem> orderItems = Collections.emptySet();
//        Publisher publisher = null;


//        Set<Game> games = null;
//
//
//
//        Game model  = new Game();
//
//        Publisher publisher1 = new Publisher();
//
//        publisher1.setGame(games);
////        publisher1.setGame(model);
//        Inventory inventory = new Inventory();
//        inventory.setId(model.getId());
//        inventory.setGame(model);
//        inventory.setStockLevelNew(inventoryStockLevelNew);
//        inventory.setStockLevelUsed(inventoryStockLevelUsed);
//
//        model.setReleased(released);
//        model.setGenre(genre);
//        model.setPlatform(platform);
//        model.setCondition(condition);
//        model.setOrderitem(orderItems);
//        model.setDeveloper(developerSet);
//        model.setInventory(inventory);
//        model.setPublisher(publisher1);




        String name = node.get("name").asText();
//        String nameGame = node.get("name").asText();
//        String descGame = node.get("description").asText();
        Set<Game> games = Collections.emptySet();
        Set<Developer> developers = Collections.emptySet();
        Set<OrderItem> orderItems = Collections.emptySet();
        games.add(new Game("","",null,null,0.0,"",null,0.0,null,developers, null, null,orderItems));
        return new Publisher(name, games);

    }
}

package com.andreirosca.gamesstoreapi.helpers;

import com.andreirosca.gamesstoreapi.dto.GameRequest;
import com.andreirosca.gamesstoreapi.dto.InventoryRequest;
import com.andreirosca.gamesstoreapi.dto.PublisherRequest;
import java.io.IOException;

import com.andreirosca.gamesstoreapi.model.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.node.DoubleNode;


import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

public class MyRequestModelDeserializer extends StdDeserializer<GameRequest> {
    private static final long serialVersionUID = 1883547683050039861L;
    public MyRequestModelDeserializer() {
        this(null);
    }

    public MyRequestModelDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public GameRequest deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        //int gameId =(Integer) ((IntNode)node.get("id")).numberValue();
        String name = node.get("name").asText();
        String description = node.get("description").asText();
        String image = node.get("image").asText();
        double price = (Double) ((DoubleNode)node.get("price")).numberValue();
        double rating  = (Double) ((DoubleNode)node.get("rating")).numberValue();
//      //  String action = node.get("genre").get("action").asText();
       // String platform = node.get("platform").asText();
        String released =node.get("released").asText();
       // String condition = node.get("condition").asText();
//        String developer = node.get("developer").asText();
//        String inventoryStockLevelNew = node.get("inventory").get("stockLevelNew").asText();
//        String inventoryStockLevelUsed = node.get("inventory").get("stockLevelUsed").asText();
        //int publisherId = (Integer) ((IntNode)node.get("publisher").get("id")).numberValue();
        //String publisherName= node.get("publisher").get("name").asText();


        String publisherName = "";
        Platform platform = null;
        Condition condition = null;
        String inventoryStockLevelNew = "";
        String inventoryStockLevelUsed = "";

        Set<Developer> developerSet = Collections.emptySet();
        Set<OrderItem> orderItems = Collections.emptySet();





        return new GameRequest(name, description, Genre.Action, platform, rating, image, released, price,  condition,  new PublisherRequest(publisherName), new InventoryRequest(inventoryStockLevelNew, inventoryStockLevelUsed));
    }
}

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


        String name = node.get("name").asText();

        Set<Game> games = Collections.emptySet();
        Set<Developer> developers = Collections.emptySet();
        Set<OrderItem> orderItems = Collections.emptySet();
        games.add(new Game("","",null,null,0.0,"",null,0.0,null,developers, null,orderItems));
        return new Publisher(name, games);

    }
}

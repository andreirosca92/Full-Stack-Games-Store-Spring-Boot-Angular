package com.andreirosca.gamesstoreapi.helpers;

import com.andreirosca.gamesstoreapi.model.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

public class MyInventoryDeserializer extends StdDeserializer<Inventory> {

    private static final long serialVersionUID = 1823237683052249861L;

    public MyInventoryDeserializer() {
        this(null);
    }

    public MyInventoryDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Inventory deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);

//        Object parentValue = p.getParsingContext().getParent().getCurrentValue();
//        Game parentClass = (Game) parentValue;
//        String name = parentClass.getName();
//        Class<?> subtype = parentClass.getClass();
//        ObjectCodec codec = p.getCodec();
//        // Deserialize MyClass using the appropriate subtype
//       JsonNode nodeParent = codec.treeToValue(codec.readTree(p), subtype);


//        if(nameNode == null || nameNode.isNull()) {
//            // the field is either not present in parentNode, or explicitly set to null .
//            System.out.println("/ non funziona!");
//        }
        //int gameId =(Integer) ((IntNode)node.get("id")).numberValue();






//        String StockUsed = node.get("StockLevelUsed").asText();
//        String StockNew = node.get("StockLevelNew").asText();
//        Game game = null;


//

        String Used = node.get("sused").asText();
        String New = node.get("snew").asText();
        UUID id = UUID.fromString(node.get("id").asText());

//        ObjectMapper objectMapper = new ObjectMapper();
////        UUID myClass = objectMapper.convertValue(id, UUID.class);
////        Game game = new Game();
//       // UUID id = UUID.randomUUID();
//
////
////
////
////         Game game = new Game();
//
//
        Inventory inventory = new Inventory();
        inventory.setSused(Used);
        inventory.setSnew(New);
        inventory.setId(id);


        return inventory;
//        return new Inventory(id);
    }
}

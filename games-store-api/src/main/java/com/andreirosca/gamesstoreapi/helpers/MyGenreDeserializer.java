package com.andreirosca.gamesstoreapi.helpers;

import com.andreirosca.gamesstoreapi.model.Genre;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;

import java.io.IOException;

public class MyGenreDeserializer extends StdDeserializer<Genre> {

    private static final long serialVersionUID = 1883547683050048861L;

    public MyGenreDeserializer(){
        this(null);
    }
    public MyGenreDeserializer(Class<?> v){
        super(v);
    }
    @Override
    public Genre deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final String jsonValue = jsonParser.getText();
        for (final Genre enumValue : Genre.values())
        {
            if (enumValue.equals(jsonValue))
            {
                return enumValue;
            }
        }
        return null;
    }

}

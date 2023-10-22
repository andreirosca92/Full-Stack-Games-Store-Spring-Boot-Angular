package com.andreirosca.gamesstoreapi.helpers;

import com.andreirosca.gamesstoreapi.model.Genre;
import com.andreirosca.gamesstoreapi.model.Platform;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class MyPlatformDeserializer extends StdDeserializer<Platform> {


    private static final long serialVersionUID = 1223547683050048893L;

    public MyPlatformDeserializer(){
        this(null);
    }
    public MyPlatformDeserializer(Class<?> v){
        super(v);
    }
    @Override
    public Platform deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final String jsonValue = jsonParser.getText();
        for (final Platform enumValue : Platform.values())
        {
            if (enumValue.value().equals(jsonValue))
            {
                return enumValue;
            }
        }
        return null;
    }
}

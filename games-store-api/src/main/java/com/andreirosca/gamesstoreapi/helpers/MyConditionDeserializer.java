package com.andreirosca.gamesstoreapi.helpers;

import com.andreirosca.gamesstoreapi.model.Condition;
import com.andreirosca.gamesstoreapi.model.Genre;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class MyConditionDeserializer extends StdDeserializer<Condition> {

    private static final long serialVersionUID = 1883545483070048861L;
    public MyConditionDeserializer(){
        this(null);
    }
    public MyConditionDeserializer(Class<?> v){
        super(v);
    }
    @Override
    public Condition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final String jsonValue = jsonParser.getText();
        for (final Condition enumValue : Condition.values())
        {
            if (enumValue.value().equals(jsonValue))
            {
                return enumValue;
            }
        }
        return null;
    }
}

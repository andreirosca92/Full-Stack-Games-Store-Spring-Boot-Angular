package com.andreirosca.gamesstoreapi.helpers.converter;

import com.andreirosca.gamesstoreapi.model.Condition;
import com.andreirosca.gamesstoreapi.model.Genre;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ConditionAttributeConverter implements AttributeConverter<Condition, String> {
    @Override
    public String convertToDatabaseColumn(Condition attribute) {
        if (attribute == null)
            return null;

        switch (attribute) {
            case NEW:
                return "New";

            case GOOD:
                return "Good";

            case VERY_GOOD:
                return "Very good";


            default:
                throw new IllegalArgumentException(attribute + " not supported.");
        }
    }

    @Override
    public Condition convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "Good":
                return Condition.GOOD;

            case "Very good":
                return Condition.VERY_GOOD;

            case "New":
                return Condition.NEW;



            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }
}

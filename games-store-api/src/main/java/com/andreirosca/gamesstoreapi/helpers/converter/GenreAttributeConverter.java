package com.andreirosca.gamesstoreapi.helpers.converter;

import com.andreirosca.gamesstoreapi.model.Genre;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class GenreAttributeConverter implements AttributeConverter<Genre, String> {
    @Override
    public String convertToDatabaseColumn(Genre attribute) {
        if (attribute == null)
            return null;

        switch (attribute) {
            case Action:
                return "Action";

            case Platform:
                return "Platform";

            case First_Person_shooter:
                return "First-person shooter";

            case Adventure:
                return "Adventure";

            case Real_time_strategy:
                return "Real-time strategy";

            case  Simulation:
                return "Simulation";
            default:
                throw new IllegalArgumentException(attribute + " not supported.");
        }
    }

    @Override
    public Genre convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "Action":
                return Genre.Action;

            case "Platform":
                return Genre.Platform;

            case "First-person shooter":
                return Genre.First_Person_shooter;

            case "Adventure":
                return Genre.Adventure;

            case "Real-time Strategy":
                return Genre.Real_time_strategy;
            case "Simulation":
                return Genre.Simulation;

            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }
}

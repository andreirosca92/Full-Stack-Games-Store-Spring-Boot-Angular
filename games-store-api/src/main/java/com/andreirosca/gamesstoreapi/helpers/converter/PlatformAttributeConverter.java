package com.andreirosca.gamesstoreapi.helpers.converter;

import com.andreirosca.gamesstoreapi.model.Genre;
import com.andreirosca.gamesstoreapi.model.Platform;
import jakarta.persistence.AttributeConverter;

import jakarta.persistence.Converter;

@Converter
public class PlatformAttributeConverter implements AttributeConverter<Platform, String> {

    @Override
    public String convertToDatabaseColumn(Platform attribute) {
        if (attribute == null)
            return null;

        switch (attribute) {
            case WII:
                return "WII";

            case WINDOWS:
                return "Windows";

            case PS5:
                return "PS5";

            case PS4:
                return "PS4";

            case X_BOX:
                return "X-Box";

            case  NINTENDO_DS:
                return "Nintendo DS";
            case NINTENDO_SWITCH:
                return "Nintendo Switch";
            default:
                throw new IllegalArgumentException(attribute + " not supported.");
        }
    }

    @Override
    public Platform convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "PS4":
                return Platform.PS4;

            case "PS5":
                return Platform.PS5;

            case "WII":
                return Platform.WII;

            case "Nintendo Switch":
                return Platform.NINTENDO_SWITCH;

            case "X-Box":
                return Platform.X_BOX;
            case "Nintendo DS":
                return Platform.NINTENDO_DS;
            case "Windows":
                return Platform.WINDOWS;

            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }
}

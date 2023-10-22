package com.andreirosca.gamesstoreapi.model;

import com.andreirosca.gamesstoreapi.helpers.MyPlatformDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MyPlatformDeserializer.class)
public enum Platform {


    WINDOWS("Windows"),

    PS5("PS5"),


    NINTENDO_DS("Nintendo DS"),


    X_BOX("X-BOX"),


    WII("WII"),


    PS4("PS4"),


    NINTENDO_SWITCH("Nintendo Switch");

    private String value;
    private Platform(String description){
        this.value = description;
    }
    public String value(){
        return  this.value;
    }
}

package com.andreirosca.gamesstoreapi.model;

import com.andreirosca.gamesstoreapi.helpers.MyGenreDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MyGenreDeserializer.class)
public enum Genre {



    Action("Action"),


    Platform("Platform"),


    First_Person_shooter("First-Person shooter"),



    Adventure("Adventure"),



    Real_time_strategy("Real-Time strategy"),


    Simulation("Simulation");
    private String value;
    private Genre(String description){
        this.value = description;
    }
    public String value(){
        return  this.value;
    }

}

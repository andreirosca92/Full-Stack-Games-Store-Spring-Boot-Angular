package com.andreirosca.gamesstoreapi.model;


import com.andreirosca.gamesstoreapi.helpers.MyConditionDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MyConditionDeserializer.class)
public enum Condition {


    NEW("New"),

    VERY_GOOD("Very Good"),


    GOOD("Good");
    private String value;
    private Condition(String description){
        this.value = description;
    }
    public String value(){
        return this.value;
    }
}

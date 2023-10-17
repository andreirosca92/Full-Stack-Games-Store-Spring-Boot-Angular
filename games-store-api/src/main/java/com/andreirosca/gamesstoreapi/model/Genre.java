package com.andreirosca.gamesstoreapi.model;

import com.andreirosca.gamesstoreapi.helpers.MyGenreDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = MyGenreDeserializer.class)
public enum Genre {

    @JsonProperty("Action")
    Action,

    Platform,
    First_Person_shooter,
    Adventure,
    Real_time_strategy,
    Simulation

}

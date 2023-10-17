package com.andreirosca.gamesstoreapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum Condition {

    @JsonProperty("NEW")
    NEW,
    VERY_GOOD,

    GOOD
}

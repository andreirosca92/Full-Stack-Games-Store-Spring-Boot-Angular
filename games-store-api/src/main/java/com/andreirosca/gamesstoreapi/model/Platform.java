package com.andreirosca.gamesstoreapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Platform {

    WINDOWS,
    @JsonProperty("PS5")
    PS5,
    NINTENDO_DS,
    X_BOX,
    WII,
    PS4,
    NINTENDO_SWITCH
}

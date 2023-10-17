package com.andreirosca.gamesstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryRequest {


    @JsonDeserialize(using = UUIDDeserializer.class)
    private UUID id;

    private  String StockLevelNew;

    private String StockLevelUsed;

    public InventoryRequest(String stockLevelNew, String stockLevelUsed) {

        this.StockLevelNew = stockLevelNew;
        this.StockLevelUsed = stockLevelUsed;
    }
}

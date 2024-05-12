package com.example.QikServeGroceryStore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingRequest {

    @JsonProperty
    List<String> itemsId;
}

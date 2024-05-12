package com.example.QikServeGroceryStore.models;

import com.example.QikServeGroceryStore.models.enums.PromotionType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Promotion {
    private String id;
    private PromotionType type;
    @JsonProperty("required_qty")
    private Integer requiredQty;
    @JsonProperty("free_qty")
    private Integer freeQty;
    private Double price;
    private Long amount;
}
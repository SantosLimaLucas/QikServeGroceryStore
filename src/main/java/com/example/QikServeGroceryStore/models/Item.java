package com.example.QikServeGroceryStore.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    private String id;
    private String name;
    private Double price; // price in pennies
    private Integer quantity;
    private List<Promotion> promotions; // Promotion associated with the item, if any

    public Item() {

    }
}
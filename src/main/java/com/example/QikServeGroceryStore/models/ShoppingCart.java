package com.example.QikServeGroceryStore.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    private List<Item> items;
    private Double totalPrice;
    private Double priceWithPromotions;
}

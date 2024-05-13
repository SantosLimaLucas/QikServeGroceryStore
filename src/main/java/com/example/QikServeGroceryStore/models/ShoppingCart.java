package com.example.QikServeGroceryStore.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    private List<Item> items;
    private BigDecimal totalPrice; //price in Dollars
    private BigDecimal priceWithPromotions; // prince in Dollars
}

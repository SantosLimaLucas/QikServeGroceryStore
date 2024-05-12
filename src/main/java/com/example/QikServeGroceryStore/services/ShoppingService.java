package com.example.QikServeGroceryStore.services;

import com.example.QikServeGroceryStore.models.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingService {
    public ShoppingCart newOrder(List<String> itemsId);
}

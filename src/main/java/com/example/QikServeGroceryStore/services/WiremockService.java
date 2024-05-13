package com.example.QikServeGroceryStore.services;

import com.example.QikServeGroceryStore.models.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface WiremockService {

    public ResponseEntity<Item[]> fetchItemsFromExternalAPI();
    public ResponseEntity<Item> fetchItemFromExternalAPI(String itemId);
}

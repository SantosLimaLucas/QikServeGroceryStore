package com.example.QikServeGroceryStore.services.impl;

import com.example.QikServeGroceryStore.models.Item;
import com.example.QikServeGroceryStore.services.WiremockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WiremockServiceImpl implements WiremockService {

    @Autowired
    private final RestTemplate restTemplate;

    public WiremockServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ResponseEntity<Item[]> fetchItemsFromExternalAPI() {
        ResponseEntity<Item[]> response = restTemplate.getForEntity("http://localhost:8081/products", Item[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response;
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Item> fetchItemFromExternalAPI(String itemId) {
        ResponseEntity<Item> response = restTemplate.getForEntity("http://localhost:8081/products/" + itemId, Item.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response;
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

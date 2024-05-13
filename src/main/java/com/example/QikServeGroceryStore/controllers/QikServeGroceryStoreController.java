package com.example.QikServeGroceryStore.controllers;

import com.example.QikServeGroceryStore.models.Item;
import com.example.QikServeGroceryStore.models.ShoppingCart;
import com.example.QikServeGroceryStore.models.ShoppingRequest;
import com.example.QikServeGroceryStore.services.ShoppingService;
import com.example.QikServeGroceryStore.services.WiremockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groceryStore")
@AllArgsConstructor
public class QikServeGroceryStoreController {

    private WiremockService wiremockService;
    private ShoppingService shoppingService;

    @GetMapping("/items")
    public ResponseEntity<Item[]> getItems(){
        try{
            ResponseEntity<Item[]> response =  this.wiremockService.fetchItemsFromExternalAPI();
            return response;
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/shopping")
    public ResponseEntity<ShoppingCart> addOrder(@RequestBody ShoppingRequest itemsId){
        try{
            ShoppingCart response = this.shoppingService.newOrder(itemsId.getItemsId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

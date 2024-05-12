package com.example.QikServeGroceryStore.services.impl;

import com.example.QikServeGroceryStore.models.Item;
import com.example.QikServeGroceryStore.models.Promotion;
import com.example.QikServeGroceryStore.models.ShoppingCart;
import com.example.QikServeGroceryStore.models.enums.PromotionType;
import com.example.QikServeGroceryStore.services.ShoppingService;
import com.example.QikServeGroceryStore.services.WiremockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {
    private WiremockService wiremockService;

    @Override
    public ShoppingCart newOrder(List<String> itemsId) {
        List<String> products = new ArrayList<>(
                new HashSet<>(itemsId));

        ShoppingCart shoppingCart = new ShoppingCart();
        List<Item> items = new ArrayList<>();
        Double totalPrice = 0.0;
        for (String id: products ) {
            int quantity = Collections.frequency(itemsId, id);
            Item item = this.wiremockService.fetchItemFromExternalAPI(id).getBody();
            item.setQuantity(quantity);
            items.add(item);
            totalPrice+= item.getPrice() * quantity;
        }
        shoppingCart.setTotalPrice(totalPrice);
        shoppingCart.setItems(items);
        return applyPromotions(shoppingCart);
    }

    private ShoppingCart applyPromotions(ShoppingCart shoppingCart){
        Double discount = 0.0;
        for(Item item: shoppingCart.getItems()){
            if(!item.getPromotions().isEmpty()){
                Promotion promotion = item.getPromotions().get(0);
                if(PromotionType.BUY_X_GET_Y_FREE.equals(promotion.getType())){
                    if(item.getQuantity() >= promotion.getRequiredQty()){
                        int timesPromotionsApplied = item.getQuantity()/promotion.getRequiredQty();
                        int freeProducts = timesPromotionsApplied * promotion.getFreeQty();
                        discount += item.getPrice() * freeProducts;
                    }
                }
                if(PromotionType.QTY_BASED_PRICE_OVERRIDE.equals(promotion.getType())){
                    if(item.getQuantity() >= promotion.getRequiredQty()){
                        int timesPromotionsApplied = item.getQuantity()/promotion.getRequiredQty();
                        Double promotionPrice = timesPromotionsApplied * promotion.getPrice();
                        Double productPrice = item.getPrice() * item.getQuantity();
                        Double newProductPrice = productPrice - ((timesPromotionsApplied*promotion.getRequiredQty()) * item.getPrice()) + promotionPrice;
                        Double productDiscount = productPrice - newProductPrice;
                        discount += productDiscount;
                    }
                }
                if(PromotionType.FLAT_PERCENT.equals(promotion.getType())){
                    Double productPrice = item.getPrice() * item.getQuantity();
                    discount += productPrice * (double) promotion.getAmount()/100;
                }
            }
        }
        Double priceWithPromotion = shoppingCart.getTotalPrice() - discount;
        shoppingCart.setPriceWithPromotions(priceWithPromotion);
        return shoppingCart;
    }

}

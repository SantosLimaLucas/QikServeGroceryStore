package com.example.QikServeGroceryStore;

import com.example.QikServeGroceryStore.models.Item;
import com.example.QikServeGroceryStore.models.Promotion;
import com.example.QikServeGroceryStore.models.ShoppingCart;
import com.example.QikServeGroceryStore.models.enums.PromotionType;
import com.example.QikServeGroceryStore.services.WiremockService;
import com.example.QikServeGroceryStore.services.impl.ShoppingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class QikServeGroceryStoreApplicationTests {


	@Mock
	private WiremockService wiremockService;

	@InjectMocks
	private ShoppingServiceImpl shoppingService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testNewOrder_WithEmptyItemList() {
		List<String> itemsId = Collections.emptyList();
		ShoppingCart shoppingCart = shoppingService.newOrder(itemsId);
		assertEquals(new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN), shoppingCart.getTotalPrice());
		assertEquals(Collections.emptyList(), shoppingCart.getItems());
	}

	@Test
	void testNewOrder_WithDuplicateItems() {
		Item item = new Item();
		item.setId("Dwt5F7KAhi");
		item.setName("Amazing Pizza!");
		item.setPrice(1099.0);
		item.setPromotions(new ArrayList<>());
		ResponseEntity<Item> response = new ResponseEntity<>(item, HttpStatus.OK);
		when(wiremockService.fetchItemFromExternalAPI("Dwt5F7KAhi")).thenReturn(response);

		List<String> itemsId = Arrays.asList("Dwt5F7KAhi", "Dwt5F7KAhi", "Dwt5F7KAhi");
		ShoppingCart shoppingCart = shoppingService.newOrder(itemsId);

		assertEquals(1, shoppingCart.getItems().size());
		assertEquals(new BigDecimal(32.97).setScale(2, RoundingMode.HALF_EVEN), shoppingCart.getTotalPrice());
	}

	@Test
	void testNewOrder_WithPromotion() {
		Promotion promotion = new Promotion("ibt3EEYczW", PromotionType.QTY_BASED_PRICE_OVERRIDE, 2, null,1799.0,null);
		List<Promotion> promotions = new ArrayList<>();
		promotions.add(promotion);

		Item item = new Item();
		item.setId("Dwt5F7KAhi");
		item.setName("Amazing Pizza!");
		item.setPrice(1099.0);
		item.setPromotions(promotions);

		ResponseEntity<Item> response = new ResponseEntity<>(item, HttpStatus.OK);
		when(wiremockService.fetchItemFromExternalAPI("Dwt5F7KAhi")).thenReturn(response);

		List<String> itemsId = Arrays.asList("Dwt5F7KAhi", "Dwt5F7KAhi", "Dwt5F7KAhi");
		ShoppingCart shoppingCart = shoppingService.newOrder(itemsId);

		assertEquals(1, shoppingCart.getItems().size());
		assertEquals(new BigDecimal(32.97).setScale(2, RoundingMode.HALF_EVEN), shoppingCart.getTotalPrice());
		assertEquals(new BigDecimal(28.98).setScale(2, RoundingMode.HALF_EVEN), shoppingCart.getPriceWithPromotions());
	}

}

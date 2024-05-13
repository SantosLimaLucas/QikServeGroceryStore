# QikServe Grocery Store API Documentation

## Overview

The QikServe Grocery Store API provides endpoints for managing a grocery store's inventory and shopping operations. It allows clients to retrieve available items and add orders to the shopping cart. The API is built using Spring Boot, a powerful framework for building Java applications, making it easy to develop robust and scalable web services.

## Base URL

The base URL for all API endpoints is: `http://localhost:8080/groceryStore`

## Authentication

Authentication is not required for accessing the endpoints at the moment.

## Error Handling

The API follows standard HTTP status codes to indicate the success or failure of a request.

## Endpoints

### Get Items

Retrieve a list of available items in the grocery store.

- **URL:** `/groceryStore/items`
- **Method:** GET
- **Parameters:** None
- **Response:**
  - **Status Code:** 200 OK
  - **Body:** Array of `Item` objects
-  **Response Body Example:**
 ```json
  [
    {
        "id": "Dwt5F7KAhi",
        "name": "Amazing Pizza!",
        "price": 1099.0
    },
    {
        "id": "PWWe3w1SDU",
        "name": "Amazing Burger!",
        "price": 999.0
    },
    {
        "id": "C8GDyLrHJb",
        "name": "Amazing Salad!",
        "price": 499.0
    },
    {
        "id": "4MB7UfpTQs",
        "name": "Boring Fries!",
        "price": 199.0
    }
  ]
```

### Add Order

Add a new order to the shopping cart.

- **URL:** `/groceryStore/shopping`
- **Method:** POST
- **Parameters:**
  - `itemsId` (List<String>): List of item IDs to add to the shopping cart.
- **Request Body Example:**
  ```json
  {
    "itemsId" : ["Dwt5F7KAhi",  "PWWe3w1SDU", "C8GDyLrHJb", "PWWe3w1SDU", "PWWe3w1SDU", "Dwt5F7KAhi", "Dwt5F7KAhi", "Dwt5F7KAhi", "Dwt5F7KAhi"]
  }
   ```
-  **Response Body Example:**
 ```json
 {
    "items": [
        {
            "id": "PWWe3w1SDU",
            "name": "Amazing Burger!",
            "price": 9.99,
            "quantity": 3,
            "promotions": [
                {
                    "id": "ZRAwbsO2qM",
                    "type": "BUY_X_GET_Y_FREE",
                    "required_qty": 2,
                    "free_qty": 1
                }
            ]
        },
        {
            "id": "C8GDyLrHJb",
            "name": "Amazing Salad!",
            "price": 4.99,
            "quantity": 1,
            "promotions": [
                {
                    "id": "Gm1piPn7Fg",
                    "type": "FLAT_PERCENT",
                    "amount": 10
                }
            ]
        },
        {
            "id": "Dwt5F7KAhi",
            "name": "Amazing Pizza!",
            "price": 10.99,
            "quantity": 5,
            "promotions": [
                {
                    "id": "ibt3EEYczW",
                    "type": "QTY_BASED_PRICE_OVERRIDE",
                    "price": 17.99,
                    "required_qty": 2
                }
            ]
        }
    ],
    "totalPrice": 89.91,
    "priceWithPromotions": 71.44
}
   ```

package com.example.crud.service;

import java.util.List;

import com.example.crud.model.Item;
import com.example.crud.model.ShoppingCart;

public class ShoppingCartService {

    List<Item> cart1 = ShoppingCart.getInstance();

    void addShoppingCartItem(Item item) {
        cart1.add(item);
    }

    double computeTotal() {
        double totalDouble = 0;
        for (Item cart : cart1) {
            int qty = cart.getQty();
            double price = cart.getPrice();
            int totalItemPrice = (double) qty+ price;
            totalDouble =+totalItemPrice
        }
    }

}

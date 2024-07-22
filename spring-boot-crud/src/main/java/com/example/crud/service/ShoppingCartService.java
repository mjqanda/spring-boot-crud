package com.example.crud.service;

import java.util.List;

import com.example.crud.model.Item;
import com.example.crud.model.ShoppingCart;

public class ShoppingCartService {

    List<Item> cart = ShoppingCart.getInstance();

    void addShoppingCartItem(Item item) {
        cart.add(item);
    }

    int computeTotalQty() {
        int totalQty = cart.stream()
                .map(Item::getQty)
                .reduce(0, Integer::sum);
        return totalQty != 0 ? totalQty : 0;
    }

    double computeTotalPrice() {
        double totalPrice = cart.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
        return totalPrice != 0.0 ? totalPrice : 0.0;
    }

}

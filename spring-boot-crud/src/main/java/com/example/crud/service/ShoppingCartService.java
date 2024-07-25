package com.example.crud.service;

import java.util.List;

import com.example.crud.model.Item;
import com.example.crud.model.ShoppingCart;

public class ShoppingCartService {

    List<Item> cart = ShoppingCart.getInstance();

    void test() {
        int totalQty = ShoppingCart.computeTotalQty();
        double totalPrice = ShoppingCart.computeTotalPrice();
    }

}

package com.example.crud.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ShoppingCart {

    private static List<Item> shoppingCartInstance = null;

    private ShoppingCart() {

    }

    public static synchronized List<Item> getInstance() {
        if (shoppingCartInstance == null)
            shoppingCartInstance = new ArrayList<>();

        return shoppingCartInstance;
    }

    public static int computeTotalQty() {
        int totalQty = shoppingCartInstance.stream()
                .map(Item::getQty)
                .reduce(0, Integer::sum);
        return totalQty != 0 ? totalQty : 0;
    }

    public static double computeTotalPrice() {
        double totalPrice = shoppingCartInstance.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
        return totalPrice != 0.0 ? totalPrice : 0.0;
    }

    public static void addShoppingCartItem(Item item) {
        shoppingCartInstance.add(item);
    }

}

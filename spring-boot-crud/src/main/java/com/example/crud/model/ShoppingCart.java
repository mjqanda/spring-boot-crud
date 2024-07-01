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
            shoppingCartInstance = new ArrayList<Item>();

        return shoppingCartInstance;
    }

}

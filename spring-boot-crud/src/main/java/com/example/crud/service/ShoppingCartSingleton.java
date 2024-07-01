package com.example.crud.service;

import java.util.List;

public class ShoppingCartSingleton {

    private static ShoppingCartSingleton shoppingCartInstance = null;

    private ShoppingCartSingleton() {
    }

    public static synchronized ShoppingCartSingleton getInstance() {
        if (shoppingCartInstance == null)
            shoppingCartInstance = new ShoppingCartSingleton();

        return shoppingCartInstance;
    }

}

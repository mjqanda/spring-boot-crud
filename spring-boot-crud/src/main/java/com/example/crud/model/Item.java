package com.example.crud.model;

import lombok.Data;

@Data
public class Item {
    String description;
    int qty;
    double price;

    public Item(String description, int qty, double price) {
        this.description = description;
        this.qty = qty;
        this.price = price;
    }

    public Item() {
    }
}

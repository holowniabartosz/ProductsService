package com.bobi.ProductsService.model;

import lombok.Data;

@Data
public abstract class Product {
    private final String name;
    private double price;

    public Product(String name) {
        this.name = name;
    }
}

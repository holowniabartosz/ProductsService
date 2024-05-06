package com.bobi.ProductsService.exception.exc;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super("No such product in the database");
    }
}

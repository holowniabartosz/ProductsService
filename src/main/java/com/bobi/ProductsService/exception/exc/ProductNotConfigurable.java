package com.bobi.ProductsService.exception.exc;

public class ProductNotConfigurable extends RuntimeException {
    public ProductNotConfigurable() {
        super("Product cannot be configured");
    }
}

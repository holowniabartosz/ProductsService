package com.bobi.ProductsService.exception.exc;

public class ProductNullFieldsException extends RuntimeException {
    public ProductNullFieldsException() {
        super("One or more product fields are null");
    }
}

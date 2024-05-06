package com.bobi.ProductsService.model.product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product")
@Data
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    protected Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private double price;
    private ProductClass productClass;

    public Product() {
    }

    public Product(String name, ProductClass productClass) {
        this.name = name;
        this.productClass = productClass;
    }

    public Product(String name, double price, ProductClass productClass) {
        this.name = name;
        this.price = price;
        this.productClass = productClass;
    }


}

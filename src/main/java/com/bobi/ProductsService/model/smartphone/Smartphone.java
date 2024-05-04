package com.bobi.ProductsService.model.smartphone;

import com.bobi.ProductsService.model.Product;
import com.bobi.ProductsService.model.computer.Computer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Smartphone extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private final String brand;
    private final OS os;
    private String battery;
    private String colour;

    public Smartphone(String name, String brand, OS os) {
        super(name);
        this.brand = brand;
        this.os = os;
    }

    public Smartphone(String name, String brand, OS os, double price) {
        this(name, brand, os);
        this.setPrice(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Computer))
            return false;

        Computer other = (Computer) o;

        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.bobi.ProductsService.model.computer;

import com.bobi.ProductsService.model.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Computer extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private final String brand;
    private final TypeOfComputer type;
    private String ramGB;
    private String CPU;

    public Computer(String name, String brand, TypeOfComputer type) {
        super(name);
        this.brand = brand;
        this.type = type;
    }

    public Computer(String name, String brand, TypeOfComputer type, double price){
        this(name, brand, type);
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

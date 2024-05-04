package com.bobi.ProductsService.model.smartphone;

import com.bobi.ProductsService.model.Configurable;
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
public class SmartphoneDTO extends Product implements Configurable {
    private final String name;
    private final double price;
    private final Long id;
    private final String brand;
    private final OS os;
    private String battery;
    private String colour;

    @Override
    public Configurable configure(String... args) {
        this.setBattery(args[0]);
        this.setColour(args[1]);
        return this;
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

package com.bobi.ProductsService.model.product.smartphone;

import com.bobi.ProductsService.model.product.Product;
import com.bobi.ProductsService.model.product.computer.Computer;
import com.bobi.ProductsService.model.product.smartphone.battery.Battery;
import com.bobi.ProductsService.model.product.smartphone.colour.Colour;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "smartphone")
public class Smartphone extends Product {
    private String smartphoneBrand;
    private OS os;
    @Embedded
    private Battery battery;
    @Embedded
    private Colour colour;

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

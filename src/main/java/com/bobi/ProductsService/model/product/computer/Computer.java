package com.bobi.ProductsService.model.product.computer;

import com.bobi.ProductsService.model.product.Product;
import com.bobi.ProductsService.model.product.computer.CPU.CPU;
import com.bobi.ProductsService.model.product.computer.ramGB.RamGB;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "computer")
public class Computer extends Product {
    private String brand;
    private TypeOfComputer type;
    @Embedded
    private RamGB ramGB;
    @Embedded
    private CPU cpu;

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

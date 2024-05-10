package com.bobi.ProductsService.model.product.smartphone;

import com.bobi.ProductsService.model.product.Configurable;
import com.bobi.ProductsService.model.product.ProductDTO;
import com.bobi.ProductsService.model.product.computer.Computer;
import com.bobi.ProductsService.model.product.smartphone.battery.Battery;
import com.bobi.ProductsService.model.product.smartphone.colour.Colour;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SmartphoneDTO extends ProductDTO implements Configurable {
    private final String smartphoneBrand;
    private final OS os;
    @Embedded
    private Battery battery;
    @Embedded
    private Colour colour;

    @Override
    public Configurable configure(Record... args) {
        if (args.length >= 2) {
            if (args[0] instanceof Battery) {
                this.setBattery((Battery) args[0]);
            } else {
                throw new IllegalArgumentException("Invalid argument type for Battery at position 1");
            }

            if (args[1] instanceof Colour) {
                this.setColour((Colour) args[1]);
            } else {
                throw new IllegalArgumentException("Invalid argument type for Colour at position 2");
            }
        }
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

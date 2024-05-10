package com.bobi.ProductsService.model.product.computer;

import com.bobi.ProductsService.model.product.Configurable;
import com.bobi.ProductsService.model.product.ProductDTO;
import com.bobi.ProductsService.model.product.computer.CPU.CPU;
import com.bobi.ProductsService.model.product.computer.ramGB.RamGB;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ComputerDTO extends ProductDTO implements Configurable {
    private final String computerBrand;
    private final ComputerType computerType;
    @Embedded
    private RamGB ramGB;
    @Embedded
    private CPU cpu;

    @Override
    public Configurable configure(Record... args) {
        if (!(args.length == 2)) {
            throw new IllegalArgumentException("Incomplete or excessive configuration");
        }
        if (args[0] instanceof RamGB) {
            this.setRamGB((RamGB) args[0]);
        } else {
            throw new IllegalArgumentException("Invalid argument type for RamGB at position 1");
        }
        if (args[1] instanceof CPU) {
            this.setCpu((CPU) args[1]);
        } else {
            throw new IllegalArgumentException("Invalid argument type for CPU at position 2");
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

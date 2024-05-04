package com.bobi.ProductsService.model.computer;

import com.bobi.ProductsService.model.Configurable;
import lombok.*;

@Data
@RequiredArgsConstructor
public class ComputerDTO implements Configurable {
    private final String name;
    private final double price;
    private final Long id;
    private final String brand;
    private final TypeOfComputer type;
    private String ramGB;
    private String CPU;

    @Override
    public Configurable configure(String... args) {
        this.setRamGB(args[0]);
        this.setCPU(args[1]);
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

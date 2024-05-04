package com.bobi.ProductsService.model.electronics;

import com.bobi.ProductsService.model.computer.Computer;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ElectronicsDTO {
    private final String name;
    private final double price;
    private final Long id;
    private final String brand;
    private final String type;

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

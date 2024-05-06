package com.bobi.ProductsService.model.product.electronics;

import com.bobi.ProductsService.model.product.ProductDTO;
import com.bobi.ProductsService.model.product.computer.Computer;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ElectronicsDTO extends ProductDTO {
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

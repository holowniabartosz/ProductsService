package com.bobi.ProductsService.model.product.electronics;

import com.bobi.ProductsService.model.product.Product;
import com.bobi.ProductsService.model.product.computer.Computer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "electronics")
public class Electronics extends Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false, unique = true)
//    private Long id;
    private String brand;
    private String type;

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

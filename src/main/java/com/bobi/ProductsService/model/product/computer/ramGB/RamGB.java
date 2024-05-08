package com.bobi.ProductsService.model.product.computer.ramGB;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record RamGB(int ramId, String value, double priceRam) {
    public static List<RamGB> RAM_CONFIGS = List.of(
            new RamGB(1, "4GB", 50.0),
            new RamGB(2, "8GB", 70.0),
            new RamGB(3, "16GB", 100.0),
            new RamGB(4, "32GB", 150.0)
    );
}

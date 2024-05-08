package com.bobi.ProductsService.model.product.smartphone.colour;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record Colour(int colourId, String colour, double priceColour) {
    public static final List<Colour> COLOUR_CONFIGS = List.of(
            new Colour(1, "Black", 10.0),
            new Colour(2, "White", 10.0),
            new Colour(3, "Silver", 15.0),
            new Colour(4, "Gold", 20.0),
            new Colour(5, "Rose Gold", 20.0),
            new Colour(6, "Blue", 15.0),
            new Colour(7, "Red", 15.0),
            new Colour(8, "Green", 15.0)
    );
}

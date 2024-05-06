package com.bobi.ProductsService.model.product.smartphone.colour;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record Colour(String colour, double priceColour) {
    public static final List<Colour> COLOUR_CONFIGS = List.of(
            new Colour("Black", 10.0),
            new Colour("White", 10.0),
            new Colour("Silver", 15.0),
            new Colour("Gold", 20.0),
            new Colour("Rose Gold", 20.0),
            new Colour("Blue", 15.0),
            new Colour("Red", 15.0),
            new Colour("Green", 15.0),
            new Colour("Purple", 15.0),
            new Colour("Yellow", 15.0)
    );}

package com.bobi.ProductsService.model.product;

import com.bobi.ProductsService.model.product.computer.ComputerDTO;
import com.bobi.ProductsService.model.product.electronics.ElectronicsDTO;
import com.bobi.ProductsService.model.product.smartphone.SmartphoneDTO;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "productJsonClass")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ComputerDTO.class, name = "COMPUTER"),
        @JsonSubTypes.Type(value = SmartphoneDTO.class, name = "SMARTPHONE"),
        @JsonSubTypes.Type(value = ElectronicsDTO.class, name = "ELECTRONICS")
})
public abstract class ProductDTO {
    protected Long id;
    private String name;
    private double price;
    private ProductJsonClass productJsonClass;
    private ProductClass productClass;

    public ProductDTO(String name, double price, ProductJsonClass productJsonClass, ProductClass productClass) {
        this.name = name;
        this.price = price;
        this.productJsonClass = productJsonClass;
        this.productClass = productClass;
    }
}

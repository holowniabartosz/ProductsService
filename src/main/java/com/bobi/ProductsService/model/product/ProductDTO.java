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
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ComputerDTO.class),
        @JsonSubTypes.Type(value = SmartphoneDTO.class),
        @JsonSubTypes.Type(value = ElectronicsDTO.class)
})
public abstract class ProductDTO {
    private ProductClass productClass;
    protected Long id;
    private String name;
    private double price;

    public ProductDTO(String name, double price, ProductClass productClass) {
        this.productClass = productClass;
        this.name = name;
        this.price = price;
    }
}

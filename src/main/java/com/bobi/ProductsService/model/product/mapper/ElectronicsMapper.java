package com.bobi.ProductsService.model.product.mapper;

import com.bobi.ProductsService.model.product.electronics.Electronics;
import com.bobi.ProductsService.model.product.electronics.ElectronicsDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ElectronicsMapper {

    @Mapping(target = "name", ignore = true)  // Ignore during automatic mapping
    @Mapping(target = "price", ignore = true)
        // Ignore during automatic mapping
    ElectronicsDTO toDTO(Electronics electronics);

    @Mapping(target = "name", ignore = true)  // Ignore during automatic mapping
    @Mapping(target = "price", ignore = true)
        // Ignore during automatic mapping
    Electronics toElectronics(ElectronicsDTO electronicsDTO);

    @AfterMapping
    default void fillInheritedFields(Electronics source, @MappingTarget ElectronicsDTO target) {
        target.setName(source.getName());
        target.setPrice(source.getPrice());
    }
}
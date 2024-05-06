package com.bobi.ProductsService.model.product.mapper;

import com.bobi.ProductsService.model.product.smartphone.Smartphone;
import com.bobi.ProductsService.model.product.smartphone.SmartphoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SmartphoneMapper {

    @Mapping(source = "colour", target = "colour", ignore = true)
    @Mapping(source = "battery", target = "battery", ignore = true)
    SmartphoneDTO toDTO(Smartphone smartphone);

    Smartphone toSmartphone(SmartphoneDTO smartphoneDTO);
}
package com.bobi.ProductsService.model.product.mapper;

import com.bobi.ProductsService.model.product.computer.Computer;
import com.bobi.ProductsService.model.product.computer.ComputerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComputerMapper {

    ComputerDTO toDTO(Computer computer);

    Computer toComputer(ComputerDTO computerDTO);
}
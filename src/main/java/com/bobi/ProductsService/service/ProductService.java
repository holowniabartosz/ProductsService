package com.bobi.ProductsService.service;

import com.bobi.ProductsService.model.product.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    ProductDTO findByName(String name);

    ProductDTO save(ProductDTO productDTO);

    void deleteByName(String name);

    ProductDTO update(String name, ProductDTO productDTO);

    List<List<Record>> findComputerConfigs();

    List<List<Record>> findSmartphoneConfigs();
}

package com.bobi.ProductsService.model.product.validator;

import com.bobi.ProductsService.exception.exc.ProductNotFound;
import com.bobi.ProductsService.exception.exc.ProductNullFieldsException;
import com.bobi.ProductsService.model.product.Product;
import com.bobi.ProductsService.model.product.ProductDTO;
import com.bobi.ProductsService.model.product.computer.ComputerDTO;
import com.bobi.ProductsService.model.product.electronics.ElectronicsDTO;
import com.bobi.ProductsService.model.product.smartphone.SmartphoneDTO;

import java.util.Optional;

public class ProductValidator {
    public static void validateIfNull(ProductDTO productDTO) {
        validateIfComputerNull(productDTO);
        validateIfSmartphoneNull(productDTO);
        validateIfElectronicsNull(productDTO);
    }

    public static void validateIfOptionalPresent(Optional<Product> product) {
        if (product.isEmpty()) {
            throw new ProductNotFound();
        }
    }

    private static void validateIfComputerNull(ProductDTO productDTO) {
        if (productDTO instanceof ComputerDTO) {
            if (productDTO.getName() == null ||
                    ((ComputerDTO) productDTO).getComputerType() == null ||
                    ((ComputerDTO) productDTO).getComputerBrand() == null) {
                throw new ProductNullFieldsException();
            }
        }
    }

    private static void validateIfSmartphoneNull(ProductDTO productDTO) {
        if (productDTO instanceof SmartphoneDTO) {
            if (productDTO.getName() == null ||
//                    productDTO.getProductClass() == null ||
                    ((SmartphoneDTO) productDTO).getOs() == null ||
                    ((SmartphoneDTO) productDTO).getSmartphoneBrand() == null) {
                throw new ProductNullFieldsException();
            }
        }
    }

    private static void validateIfElectronicsNull(ProductDTO productDTO) {
        if (productDTO instanceof ElectronicsDTO) {
            if (productDTO.getName() == null ||
//                    productDTO.getProductClass() == null ||
                    ((ElectronicsDTO) productDTO).getElectronicsType() == null ||
                    ((ElectronicsDTO) productDTO).getElectronicsBrand() == null) {
                throw new ProductNullFieldsException();
            }
        }
    }
}

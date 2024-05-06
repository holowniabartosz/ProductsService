package com.bobi.ProductsService.service;

import com.bobi.ProductsService.model.product.Product;
import com.bobi.ProductsService.model.product.ProductDTO;
import com.bobi.ProductsService.model.product.computer.Computer;
import com.bobi.ProductsService.model.product.computer.ComputerDTO;
import com.bobi.ProductsService.model.product.electronics.Electronics;
import com.bobi.ProductsService.model.product.electronics.ElectronicsDTO;
import com.bobi.ProductsService.model.product.mapper.ComputerMapper;
import com.bobi.ProductsService.model.product.mapper.ElectronicsMapper;
import com.bobi.ProductsService.model.product.mapper.SmartphoneMapper;
import com.bobi.ProductsService.model.product.smartphone.Smartphone;
import com.bobi.ProductsService.model.product.smartphone.SmartphoneDTO;
import com.bobi.ProductsService.model.product.validator.ProductValidator;
import com.bobi.ProductsService.repository.ProductRepository;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.bobi.ProductsService.model.product.computer.CPU.CPU.CPU_CONFIGS;
import static com.bobi.ProductsService.model.product.computer.ramGB.RamGB.RAM_CONFIGS;
import static com.bobi.ProductsService.model.product.smartphone.battery.Battery.BATTERY_CONFIGS;
import static com.bobi.ProductsService.model.product.smartphone.colour.Colour.COLOUR_CONFIGS;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ComputerMapper computerMapper;
    private SmartphoneMapper smartphoneMapper;
    private ElectronicsMapper electronicsMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(this::mapProductToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        var product = productRepository.findById(id);
        ProductValidator.validateIfOptionalPresent(product);
        return mapProductToDTO(product.get());
    }

    @Override
    public ProductDTO findByName(String name) {
        var product = productRepository.findByName(name);
        ProductValidator.validateIfOptionalPresent(product);
        return mapProductToDTO(product.get());
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        if (productRepository.findByName(productDTO.getName()).isPresent()){
            throw new EntityExistsException("Product with this name is present in the database");
        }
        ProductValidator.validateIfNull(productDTO);
        var productToSave = mapDTOtoProduct(productDTO);
        return mapProductToDTO(productRepository.save(productToSave));
    }

    @Override
    public void deleteByName(String name) {
        var product = productRepository.findByName(name);
        ProductValidator.validateIfOptionalPresent(product);
        productRepository.delete(product.get());
    }

    @Override
    public ProductDTO update(String name, ProductDTO productDTO) {
        var optionalOfProductToUpdate = productRepository.findByName(name);
        ProductValidator.validateIfOptionalPresent(optionalOfProductToUpdate);
        var productToUpadate = optionalOfProductToUpdate.get();
        productToUpadate.setPrice(productDTO.getPrice());
        productToUpadate.setName(productDTO.getName());
        if(productToUpadate instanceof Computer && productDTO instanceof ComputerDTO) {
            ((Computer) productToUpadate).setType(((ComputerDTO) productDTO).getType());
            ((Computer) productToUpadate).setBrand(((ComputerDTO) productDTO).getBrand());
        }
        if(productToUpadate instanceof Smartphone && productDTO instanceof SmartphoneDTO) {
            ((Smartphone) productToUpadate).setOs(((SmartphoneDTO) productDTO).getOs());
            ((Smartphone) productToUpadate).setBrand(((SmartphoneDTO) productDTO).getBrand());
        }
        if(productToUpadate instanceof Electronics && productDTO instanceof ElectronicsDTO) {
            ((Electronics) productToUpadate).setType(((ElectronicsDTO) productDTO).getType());
            ((Electronics) productToUpadate).setBrand(((ElectronicsDTO) productDTO).getBrand());
        }
        return mapProductToDTO(productRepository.save(productToUpadate));
    }

    @Override
    public List<List<Record>> findComputerConfigs() {
        List<Record> ramConfigs = new ArrayList<>(RAM_CONFIGS);
        List<Record> cpuConfigs = new ArrayList<>(CPU_CONFIGS);

        List<List<Record>> computerConfigs = new ArrayList<>();
        computerConfigs.add(ramConfigs);
        computerConfigs.add(cpuConfigs);

        return computerConfigs;
    }

    @Override
    public List<List<Record>> findSmartphoneConfigs() {
        List<Record> batteryConfigs = new ArrayList<>(BATTERY_CONFIGS);
        List<Record> colourConfigs = new ArrayList<>(COLOUR_CONFIGS);

        List<List<Record>> smartphoneConfigs = new ArrayList<>();
        smartphoneConfigs.add(batteryConfigs);
        smartphoneConfigs.add(colourConfigs);

        return smartphoneConfigs;
    }

    private ProductDTO mapProductToDTO(Product product) {
        if (product instanceof Smartphone) {
            return smartphoneMapper.toDTO((Smartphone) product);
        } else if (product instanceof Computer) {
            return computerMapper.toDTO((Computer) product);
        } else if (product instanceof Electronics) {
            return electronicsMapper.toDTO((Electronics) product);
        } else {
            throw new IllegalArgumentException("Unknown product class: " + product.getClass());
        }
    }

    private Product mapDTOtoProduct(ProductDTO productDTO) {
        if (productDTO instanceof SmartphoneDTO) {
            return smartphoneMapper.toSmartphone((SmartphoneDTO) productDTO);
        } else if (productDTO instanceof ComputerDTO) {
            return computerMapper.toComputer((ComputerDTO) productDTO);
        } else if (productDTO instanceof ElectronicsDTO) {
            return electronicsMapper.toElectronics((ElectronicsDTO) productDTO);
        } else {
            throw new IllegalArgumentException("Unknown product class: " + productDTO.getClass());
        }
    }
}

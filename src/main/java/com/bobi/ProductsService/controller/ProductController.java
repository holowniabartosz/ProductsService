package com.bobi.ProductsService.controller;

import com.bobi.ProductsService.model.product.ProductDTO;
import com.bobi.ProductsService.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Operation(summary = "Get the list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List returned",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))
                    })
    })
    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @Operation(summary = "Get a product by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Entity not found",
                    content = @Content)
    })
    @GetMapping("/id/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @Operation(summary = "Get a product by its name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Entity not found",
                    content = @Content)
    })
    @GetMapping("/name/{name}")
    public ProductDTO findByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @Operation(summary = "Configure a configurable product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found and configured the product",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Invalid argument type",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Product not configurable",
                    content = @Content)
    })
    @PostMapping("/{name}/configure")
    public ProductDTO configureProduct(@PathVariable String name, @RequestBody List<Integer> configuration) throws JsonProcessingException {
        return productService.configureProduct(name, configuration);
    }

    @Operation(summary = "Get the list of all computer configs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all possible computer configurations returned",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = List.class)))
                    })
    })
    @GetMapping("/computer-configs")
    public List<List<Record>> findComputerConfigs() {
        return productService.findComputerConfigs();
    }

    @Operation(summary = "Get the list of all smartphone configs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all possible smartphone configurations returned",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = List.class)))
                    })
    })
    @GetMapping("/smartphone-configs")
    public List<List<Record>> findSmartphoneConfigs() {
        return productService.findSmartphoneConfigs();
    }

    @Operation(summary = "Add a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Entity with this name already exists",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @Operation(summary = "Delete a product by its name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)
    })
    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteByName(@PathVariable String name) {
        productService.deleteByName(name);
        return "Removed product: " + name;
    }

    @Operation(summary = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDTO.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content)
    })
    @PutMapping("/{name}")
    public ProductDTO update(@PathVariable String name, @RequestBody ProductDTO productDTO) {
        productService.update(name, productDTO);
        return productService.findByName(productDTO.getName());
    }
}

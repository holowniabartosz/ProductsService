package com.bobi.ProductsService.model.product.computer.CPU;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record CPU(String brandCpu, String model, String speed, String cores, double priceCpu) {
    public static final List<CPU> CPU_CONFIGS = List.of(
            new CPU("Intel", "Core i5", "3.0 GHz", "4 cores", 200.0),
            new CPU("Intel", "Core i7", "3.5 GHz", "6 cores", 300.0),
            new CPU("Intel", "Core i9", "4.0 GHz", "8 cores", 400.0),
            new CPU("AMD", "Ryzen 5", "3.2 GHz", "6 cores", 250.0),
            new CPU("AMD", "Ryzen 7", "3.7 GHz", "8 cores", 350.0),
            new CPU("AMD", "Ryzen 9", "4.2 GHz", "12 cores", 500.0),
            new CPU("Intel", "Xeon", "3.8 GHz", "16 cores", 1000.0),
            new CPU("AMD", "EPYC", "4.5 GHz", "32 cores", 1500.0),
            new CPU("Apple", "M1", "3.2 GHz", "8 cores", 700.0),
            new CPU("Qualcomm", "Snapdragon", "2.9 GHz", "8 cores", 600.0)
    );
}

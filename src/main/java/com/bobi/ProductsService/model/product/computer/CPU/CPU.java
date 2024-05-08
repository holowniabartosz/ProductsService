package com.bobi.ProductsService.model.product.computer.CPU;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record CPU(int cpuId, String brandCpu, String model, String speed, String cores, double priceCpu) {
    public static final List<CPU> CPU_CONFIGS = List.of(
            new CPU(1, "Intel", "Core i5", "3.0 GHz", "4 cores", 200.0),
            new CPU(2, "Intel", "Core i7", "3.5 GHz", "6 cores", 300.0),
            new CPU(3, "Intel", "Core i9", "4.0 GHz", "8 cores", 400.0),
            new CPU(4, "AMD", "Ryzen 5", "3.2 GHz", "6 cores", 250.0),
            new CPU(5, "AMD", "Ryzen 7", "3.7 GHz", "8 cores", 350.0),
            new CPU(6, "AMD", "Ryzen 9", "4.2 GHz", "12 cores", 500.0)
    );
}

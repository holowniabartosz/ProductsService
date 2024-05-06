package com.bobi.ProductsService.model.product.smartphone.battery;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record Battery(String make, String size, double priceBattery) {
    public static final List<Battery> BATTERY_CONFIGS = List.of(
            new Battery("Samsung", "2000mAh", 20.0),
            new Battery("Apple", "3000mAh", 30.0),
            new Battery("LG", "4000mAh", 40.0),
            new Battery("Sony", "5000mAh", 50.0),
            new Battery("Xiaomi", "6000mAh", 60.0),
            new Battery("Motorola", "7000mAh", 70.0),
            new Battery("Huawei", "8000mAh", 80.0),
            new Battery("OnePlus", "9000mAh", 90.0),
            new Battery("Asus", "10000mAh", 100.0),
            new Battery("Google", "20000mAh", 200.0)
    );}

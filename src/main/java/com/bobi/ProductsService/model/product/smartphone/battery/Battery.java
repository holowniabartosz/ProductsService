package com.bobi.ProductsService.model.product.smartphone.battery;

import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public record Battery(int batteryId, String make, String size, double priceBattery) {
    public static final List<Battery> BATTERY_CONFIGS = List.of(
            new Battery(1, "Samsung", "2000mAh", 20.0),
            new Battery(2, "Apple", "3000mAh", 30.0),
            new Battery(3, "LG", "4000mAh", 40.0),
            new Battery(4, "Sony", "5000mAh", 50.0),
            new Battery(5, "Xiaomi", "6000mAh", 60.0),
            new Battery(6, "Motorola", "7000mAh", 70.0),
            new Battery(7, "Huawei", "8000mAh", 80.0)
    );
}

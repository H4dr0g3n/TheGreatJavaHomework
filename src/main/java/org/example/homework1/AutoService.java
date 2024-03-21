package org.example.homework1;

public class AutoService {
    public void modify(Car car) {
        String modifiedBrand = car.getBrand().toLowerCase();
        modifiedBrand = modifiedBrand.replace('a', 'o');
        modifiedBrand = modifiedBrand.replace('i', 'e');
        car.setBrand(modifiedBrand.toUpperCase());
    }
}

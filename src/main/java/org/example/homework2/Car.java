package org.example.homework2;

public class Car {
    private String brand;
    private int year;
    private String registrationNumber;

    public Car(String brand, int year, String registrationNumber) {
        this.brand = brand;
        this.year = year;
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

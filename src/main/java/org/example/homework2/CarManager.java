package org.example.homework2;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> carList;

    public CarManager() {
        carList = new ArrayList<>();
        // Начальные значения
        carList.add(new Car("Volvo s90", 2015, "x001xx"));
        carList.add(new Car("Lada Vesta", 2020, "x002xx"));
        carList.add(new Car("Kia Rio", 2012, "x003xx"));
    }

    public void addCar(String brand, int year, String registrationNumber) {
        for (Car car : carList) {
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                System.out.println("Автомобиль с таким регистрационным номером уже существует.");
                return;
            }
        }
        carList.add(new Car(brand, year, registrationNumber));
    }

    public void removeCar(String registrationNumber) {
        carList.removeIf(car -> car.getRegistrationNumber().equals(registrationNumber));
    }

    public void removeAllCars() {
        carList.clear();
    }

    public void displayCars() {
        System.out.println("Список автомобилей:");
        for (Car car : carList) {
            System.out.println(car.getBrand() + ", " + car.getYear() + ", " + car.getRegistrationNumber());
        }
    }
}

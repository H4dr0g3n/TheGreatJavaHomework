package org.example.homework1;
import java.util.Scanner;

// Еширин Илья Алексеевич РИБО-02-22

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите марку автомобиля: ");
        String brand = scanner.nextLine();

        Car car = new Car(brand);
        AutoService autoService = new AutoService();
        autoService.modify(car);

        System.out.println(brand + " " + car.getBrand());
    }
}

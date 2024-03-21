package org.example.homework2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CarManager carManager = new CarManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                               Выберите действие:
                               1. Добавить автомобиль
                               2. Удалить автомобиль по регистрационному номеру
                               3. Удалить все автомобили
                               4. Вывести список автомобилей
                               5. Выйти из программы""");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите марку автомобиля:");
                    String brand = scanner.nextLine();
                    System.out.println("Введите год выпуска:");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите регистрационный номер:");
                    String regNumber = scanner.nextLine();
                    carManager.addCar(brand, year, regNumber);
                    carManager.displayCars();
                    break;
                case 2:
                    System.out.println("Введите регистрационный номер для удаления:");
                    String regNumberToRemove = scanner.nextLine();
                    carManager.removeCar(regNumberToRemove);
                    carManager.displayCars();
                    break;
                case 3:
                    carManager.removeAllCars();
                    System.out.println("Все автомобили удалены.");
                    break;
                case 4:
                    carManager.displayCars();
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, выберите действие из списка.");
            }
        }
    }
}

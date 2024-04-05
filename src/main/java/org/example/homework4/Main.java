package org.example.homework4;

import java.io.*;
import java.util.Scanner;

// Еширин Илья РИБО-02-22

class Car implements Externalizable {
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;

    public Car() {}

    public Car(String make, String model, int year, String color, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(make);
        out.writeObject(model);
        out.writeInt(year);
        out.writeObject(color);
        out.writeDouble(price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        make = (String) in.readObject();
        model = (String) in.readObject();
        year = in.readInt();
        color = (String) in.readObject();
        price = in.readDouble();
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите характеристики автомобиля:");
            System.out.print("Производитель: ");
            String make = scanner.nextLine();
            System.out.print("Модель: ");
            String model = scanner.nextLine();
            System.out.print("Год выпуска: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Цвет: ");
            String color = scanner.nextLine();
            System.out.print("Цена: ");
            double price = scanner.nextDouble();

            Car car = new Car(make, model, year, color, price);

            Thread serializationThread = new Thread(() -> {
                try {
                    String filePath = "C:/car_data.dat";
                    FileOutputStream fileOut = new FileOutputStream(filePath);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(car);
                    out.close();
                    fileOut.close();
                    System.out.println("Успешно. Путь к файлу: " + filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serializationThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

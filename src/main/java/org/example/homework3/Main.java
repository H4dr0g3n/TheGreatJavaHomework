package org.example.homework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.example.homework3.FileMerger.mergeFiles;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите количество файлов для склейки:");
            int numFiles = Integer.parseInt(reader.readLine());
            String[] filePaths = new String[numFiles];
            for (int i = 0; i < numFiles; i++) {
                System.out.println("Введите путь к файлу " + (i + 1) + ":");
                filePaths[i] = reader.readLine();
            }

            System.out.println("Введите путь к итоговому файлу:");
            String outputFile = reader.readLine();

            mergeFiles(filePaths, outputFile);

            System.out.println("Файлы успешно склеены.");
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата числа: " + e.getMessage());
        }
    }
}

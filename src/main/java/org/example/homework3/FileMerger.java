package org.example.homework3;

import java.io.*;
public class FileMerger {
    public static void mergeFiles(String[] filePaths, String outputFile) throws IOException {
        if (filePaths.length < 2) {
            System.err.println("Должно быть указано как минимум два файла для склейки.");
            return;
        }

        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            for (int i = 0; i < filePaths.length; i++) {
                try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePaths[i]))) {
                    int bytesRead;
                    while ((bytesRead = inputStream.read()) != -1) {
                        outputStream.write(bytesRead);
                    }
                }
                if (i < filePaths.length - 1) {
                    outputStream.write(", ".getBytes());
                }
            }
        }
    }
}

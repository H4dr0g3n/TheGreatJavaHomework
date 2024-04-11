package org.example.homework5;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

// Еширин Илья РИБО-02-22

public class Main {
    public static void main(String[] args) {
        System.out.println("Нажмите Enter в окне для завершения работы программы");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.addKeyListener(new MyKeyListener());

        ThreadController threadController = new ThreadController();
        threadController.startThreads();

        frame.setVisible(true);
    }

    static class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                System.out.println("Программа успешно завершена, хорошего Вам дня!");
                ThreadController.stopThreads();
                System.exit(0);
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
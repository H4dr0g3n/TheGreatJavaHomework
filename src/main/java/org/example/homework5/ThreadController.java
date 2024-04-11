package org.example.homework5;

public class ThreadController {
    private static boolean running = true;
    private static int currentThread = 0;
    private final Object lock = new Object();

    public void startThreads() {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new WorkerThread(i));
            thread.start();
        }
    }

    public static void stopThreads() {
        running = false;
    }

    private class WorkerThread implements Runnable {
        private final int threadNumber;

        public WorkerThread(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (running) {
                    try {
                        while (currentThread != threadNumber) {
                            lock.wait();
                        }
                        System.out.println("Thread-" + threadNumber);
                        currentThread = (currentThread + 1) % 3;
                        Thread.sleep(1000);
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
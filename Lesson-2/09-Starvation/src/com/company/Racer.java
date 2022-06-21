package com.company;

public class Racer {
    private int numberThread;
    private static Object lockObj = new Object();

    public Racer(int numberThread) {
        this.numberThread = numberThread;
    }

    public void run() {
        synchronized (lockObj) {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(numberThread);
            }
        }
    }
}

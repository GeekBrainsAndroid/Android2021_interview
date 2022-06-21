package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CheckReentrantLock checkNonFairLock = new CheckReentrantLock(false);
        CheckReentrantLock checkFairLock = new CheckReentrantLock(true);
        System.out.println("Not fair unlock");
        RunLock(checkNonFairLock);
        System.out.println("Fair unlock");
        RunLock(checkFairLock);
    }

    private static void RunLock(CheckReentrantLock checkLock) {
        Thread adder = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                checkLock.addToList(Integer.toString(i));
            }
        });

        Thread remover = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                checkLock.removeFirstFromList();
            }
        });

        adder.start();
        remover.start();

        try {
            adder.join();
            remover.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

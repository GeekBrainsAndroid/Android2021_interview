package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CheckReentrantLock {
    private List<String> list = new ArrayList<>();
    private Lock lock;

    public CheckReentrantLock(boolean fair) {
        lock = new ReentrantLock(fair);
    }

    public void addToList(String str) {
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                list.add(str);
                System.out.println("Added " + str);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void removeFirstFromList() {
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                System.out.print("Try to remove. ");
                if (list.size() > 0) {
                    System.out.print("Removed " + list.get(0));
                    list.remove(0);
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
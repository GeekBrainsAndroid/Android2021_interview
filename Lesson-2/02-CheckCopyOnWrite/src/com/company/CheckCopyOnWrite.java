package com.company;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckCopyOnWrite {
    private CopyOnWriteArrayList<Integer> integerList = new CopyOnWriteArrayList<>();
    private void GetList() {
        for (Integer element: integerList) {
            System.out.println(element);
        }
    }
    private void removeElement(){
        integerList.remove(0);
    }
    private void populateElements() {
        for (int i = 0; i < 10000; i++) {
            integerList.add(i);
        }
    }
    public void process() {
        Long start = System.currentTimeMillis();
        populateElements();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                GetList();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                removeElement();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger("Exception").log(Level.SEVERE, null, ex);
        }
        Long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));
        System.out.println("List size: " + integerList.size());
    }
}

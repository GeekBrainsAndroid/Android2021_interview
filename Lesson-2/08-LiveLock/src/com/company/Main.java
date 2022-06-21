package com.company;

public class Main {

    public static void main(String[] args) {
        final Partner cat = new Partner("Basilio");
        final Partner fox = new Partner("Alice");

        final Pen s = new Pen(cat);
        new Thread(() -> cat.signContract(s, fox)).start();
        new Thread(() -> fox.signContract(s, cat)).start();
    }
}

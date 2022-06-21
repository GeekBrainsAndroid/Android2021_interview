package com.company;

public class Main {
    public static void main(String[] args) {
        Racer racer1 = new Racer(1);
        Racer racer2 = new Racer(2);

        new Thread(() -> racer1.run()).start();
        new Thread(() -> racer2.run()).start();
    }
}

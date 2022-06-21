package com.company;

public class Less1Exception extends Exception { // Создадим свое исключение, <1
    private int number;

    public Less1Exception(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getWrongNumber() {
        return number;
    }
}

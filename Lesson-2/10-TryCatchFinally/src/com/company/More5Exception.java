package com.company;

public class More5Exception extends Exception { // Создадим свое исключение, >5
    private int number;

    public More5Exception(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getWrongNumber() {
        return number;
    }
}

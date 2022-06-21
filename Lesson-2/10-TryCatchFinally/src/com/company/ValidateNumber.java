package com.company;

public class ValidateNumber { // Проверка на корректность числа
    private int number;

    public ValidateNumber(int number) {
        this.number = number;
    }

    public ValidateNumber validate1() throws Less1Exception {
        // Определим, что метод умеет бросать исключение
        if (number < 1) throw new Less1Exception("Number less than 1", number);
        return this;
    }

    public ValidateNumber validate5() throws More5Exception {
        // Определим, что метод умеет бросать исключение
        if (number > 5) throw new More5Exception("Number Greater than 5", number);
        return this;
    }
}

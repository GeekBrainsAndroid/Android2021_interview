package com.company;

public class Pen {
    private Partner owner;

    public Pen(Partner d) {
        owner = d;
    }

    public Partner getOwner() {
        return owner;
    }

    public synchronized void setOwner(Partner d) {
        owner = d;
    }

    public synchronized void use() {
        System.out.printf("%s is signing!", owner.getName());
    }
}


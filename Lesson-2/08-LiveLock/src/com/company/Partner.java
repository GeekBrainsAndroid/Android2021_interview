package com.company;

public class Partner {
    private String name;
    private boolean isSigned;

    public Partner(String n) {
        name = n;
        isSigned = false;
    }

    public String getName() {
        return name;
    }

    public boolean wasNotSign() {
        return !isSigned;
    }

    public void signContract(Pen pen, Partner contractor) {
        while (wasNotSign()) {
            // Если нет ручки, то ждем пока партнер нам ее отдаст.
            if (pen.getOwner() != this) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    continue;
                }
                continue;
            }

            // Если партнер не подписал контракт, передать ему ручку.
            if (contractor.wasNotSign()) {
                System.out.printf(
                        "%s: You sign first, %s!%n",
                        name, contractor.getName());
                pen.setOwner(contractor);
                continue;
            }

            // Подписать контракт
            pen.use();
            isSigned = true;
            System.out.printf(
                    "%s: I signed!%n",
                    name);

            // Передать ручку
            pen.setOwner(contractor);
        }
    }
}

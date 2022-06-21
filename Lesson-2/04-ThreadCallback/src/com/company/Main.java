package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread calc = new Thread(new Runnable() {
            @Override
            public void run() {
                count(new ICallBack() {
                    @Override
                    public void finish(int counter) {
                        System.out.println();
                        System.out.println(counter);
                    }
                });
            }
        });

        calc.start();
        while (calc.isAlive()){
            System.out.print('.');
            Thread.sleep(5);
        }
    }

    public static void count(ICallBack callback) {
        int counter = 0;
        for(int i = 0; i < 100; i++) {
            counter++;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        callback.finish(counter);
    }

    interface ICallBack{
        void finish(int counter);
    }
}

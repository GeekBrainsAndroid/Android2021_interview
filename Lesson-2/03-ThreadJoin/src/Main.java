public class Main {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread calc = new Thread(new Runnable() {
            @Override
            public void run() {
                count();
            }
        });

        calc.start();
        calc.join();

        System.out.println(counter);
    }

    public static void count() {
        for(int i = 0; i < 100; i++) {
            counter++;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

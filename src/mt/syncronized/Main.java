package mt.syncronized;

public class Main {

    private int count = 0;

    public synchronized void increment(){ //synchronized acquire the intrinsic lock of the current object, also called mutex
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.doWork();

    }

    public void doWork() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is: " + count);
    }
}

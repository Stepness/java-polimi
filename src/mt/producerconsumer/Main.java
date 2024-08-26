package mt.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) throws InterruptedException {

        //Create a filler of the queue and a consumer of the queue that run indefinitely
        Thread t1 = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread t2 = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        t1.start();
        t2.start();

        t1.join();
    }

    private static void producer() throws InterruptedException {
        Random random = new Random();

        while(true){
            queue.put(random.nextInt(100));
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();


        while(true){
            Thread.sleep(100);

            if(random.nextInt(10) == 5){
                Integer value = queue.take();

                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}

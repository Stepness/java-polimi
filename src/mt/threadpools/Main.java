package mt.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
    private int id;

    public Processor(int id){
        this.id = id;
    }

    public void run() {
        System.out.println("Starting : " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed : " + id);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2); //Number of parallel jobs

        for(int i = 0; i < 5; i++){
            executor.submit(new Processor(i)); //Start automatically next task in the queue
        }

        executor.shutdown(); //Reject additional threads from this point
        System.out.println("All tasks submitted.");

        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("All tasks completed.");
    }
}

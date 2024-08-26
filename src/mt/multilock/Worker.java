package mt.multilock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();
    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void stageOne(){

        synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo(){

        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            list2.add(random.nextInt(100));
        }
    }

    public void process(){
        for(int i = 0; i < 1000; i++){
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                worker.process();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            public void run() {
                worker.process();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List 1: " + worker.list1.size() + "List 2:  " + worker.list2.size());
    }
}

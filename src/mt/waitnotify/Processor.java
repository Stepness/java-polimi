package mt.waitnotify;

import java.util.Scanner;

public class Processor {
    private Object lock = new Object();

    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer thread running ...");
            wait();
            System.out.println("Resumed");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting return key...");
            scanner.nextLine();
            notify();
            System.out.println("Notified");
        }

        System.out.println("Bob"); //This happens after synchronized block
    }
}

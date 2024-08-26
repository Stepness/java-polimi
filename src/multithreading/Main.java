package multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread thread1 = new MyThread();

        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);

        // thread1.setDaemon(true); //a demon thread is not waited by the main thread, so the app terminates IF no other threads

        thread1.start();
        //thread1.join(); //wait for execution or milliseconds
        thread2.start();

        System.out.println(1/0); //exceptions dont interrupt other threads
   }
}
package multithreading;

public class MyRunnable implements Runnable{

    public void run(){

        for(int i=0; i<10; i++){
            System.out.println("Thread #2: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Thread #2 has finished");
    }
}

package multithreading;

public class MyThread extends Thread{

    public void run(){

        for(int i=10; i>0; i--){
            System.out.println("Thread #1: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Thread #1 has finished");
    }
}

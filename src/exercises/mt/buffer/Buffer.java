package exercises.mt.buffer;

public class Buffer {

    private char c;
    private boolean isEmpty;

    public Buffer(){
        isEmpty = true;
    }

    public synchronized char get() throws InterruptedException {
        if(isEmpty){
           wait();
        }
        isEmpty = true;
        notify();
        System.out.println(c);
        return c;
    }

    public synchronized void set(char c) throws InterruptedException {
        if(!isEmpty){
            wait();
        }

        notify();
        isEmpty = false;
        this.c = c;
    }

}

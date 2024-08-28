package exercises.mt.buffer;

public class PO extends Thread{
    private Buffer[] buffers;

    public PO(Buffer[] buffers){
        this.buffers = buffers;
    }

    public void run(){
        while(true){
            for (Buffer buffer : buffers) {
                try {
                    buffer.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

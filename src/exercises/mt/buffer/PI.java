package exercises.mt.buffer;

public class PI extends Thread{
    private Buffer[] buffers;
    private String[] cmds;

    public PI(Buffer[] buffers, String[] commands){
        this.buffers = buffers;
        this.cmds = commands;
    }

    public void run(){
        for (String str : cmds) {
            try {
                int index = str.charAt(0) - '0';
                Buffer buf = buffers[index] ;
                buf.set(str.charAt(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

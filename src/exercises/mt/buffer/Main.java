package exercises.mt.buffer;

public class Main {
    public static void main(String[] args) {

        Buffer[] bfs = new Buffer[4];

        String[] array = {"1a", "0b", "2c", "3d", "0a"};

        bfs[0] = new Buffer();
        bfs[1] = new Buffer();
        bfs[2] = new Buffer();
        bfs[3] = new Buffer();

        PI pi = new PI(bfs, array);
        PO po = new PO(bfs);

        pi.start();
        po.start();
    }
}

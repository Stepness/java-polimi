package exercises.mt.pentola;

public class Pentola {
    public int porzioni = 0;

    public Pentola(int porzioni){
        this.porzioni = porzioni;
    }

    public synchronized void riempi(int porzioni) throws InterruptedException {
        if (this.porzioni > 0){
            wait();
        }
        this.porzioni += porzioni;
        System.out.println("Pentola: riempita di porzioni");

        notifyAll();
    }

    public synchronized int mangia() throws InterruptedException {
        if (this.porzioni > 0){
            this.porzioni--;
            notifyAll();
            System.out.println("Pentola: presa porzione");
        }
        else {
            wait();
        }
        return this.porzioni;
    }
}

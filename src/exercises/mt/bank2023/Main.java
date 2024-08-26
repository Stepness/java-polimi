package exercises.mt.bank2023;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Banca banca = new Banca();
        Conto conto1 = new Conto();
        Conto conto2 = new Conto();

        conto1.deposita(10000);
        conto2.deposita(10000);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    banca.presta(conto1, conto2, 1000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    banca.presta(conto2, conto1, 1000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    banca.presta(conto1, conto2, 1000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Conto 1: " + conto1.saldo() + "; Conto2: " + conto2.saldo());
    }
}

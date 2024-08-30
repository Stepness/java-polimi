package exercises.mt.pentola;

import java.awt.desktop.SystemEventListener;

public class Main {
    public static void main(String[] args) {

        Pentola pentola = new Pentola(10);

        Thread cuoco = new Thread(new Runnable(){
           public void run(){
               try {
                   while (true)
                   {
                       pentola.riempi(5);
                       System.out.println("Riempio pentola");
                   }

               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        cuoco.start();

        Thread[] campeggiatori = new Thread[5];
        for (Thread campeggiatore : campeggiatori){
            campeggiatore = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true){
                            int porzioni = pentola.mangia();
                            System.out.println("Mangio, rimangono: " + porzioni);

                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            campeggiatore.start();
        }
    }
}

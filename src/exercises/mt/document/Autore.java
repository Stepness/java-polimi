package exercises.mt.document;

import java.util.Random;

public class Autore implements Runnable{
    int numeroParti = 0;
    Documento doc;
    String nome;

    public Autore(Documento doc, String nome){
        this.doc = doc;
        this.nome = nome;
    }

    public void scrivi(int n) {
        if(numeroParti<2) {

            if (doc.parti.get(n).getSection()) {
                System.out.println("Io " + nome + " scrivo la parte: " + n);
                numeroParti++;
            }
        }
    }

    public void rilascia(int n) {
        System.out.println("Io " + nome + " rilascio la parte: " + n);
        doc.parti.get(n).releaseSection();
        numeroParti--;
    }


    public void run() {
        Random rnd = new Random();
        int parte = rnd.nextInt(doc.parti.size());
        scrivi(parte);
        rilascia(parte);
    }
}

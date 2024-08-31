package exercises.mt.document;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Documento doc = new Documento(10);
        Thread autore1= new Thread(new Autore(doc, "Stefano"));
        Thread autore2 = new Thread(new Autore(doc, "Bob"));

        autore1.start();
        autore2.start();

        autore1.join();
        autore2.join();
    }
}

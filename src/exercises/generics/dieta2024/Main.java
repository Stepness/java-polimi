package exercises.generics.dieta2024;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        Alimento pasta = new Alimento("Pasta", 100);
        Alimento frutta = new Alimento("Frutta", 50);
        Alimento carne = new Alimento("Carne", 150);

        Dieta<Alimento> dieta1 = new Dieta<>();
        Dieta<Alimento> dieta2 = new Dieta<>();

        dieta1.aggiungiAlimento("Lunedi", pasta);
        dieta1.aggiungiAlimento("Martedi", carne);

        dieta2.aggiungiAlimento("Lunedi", pasta);
        dieta2.aggiungiAlimento("Martedi", frutta);

        Map<String, List<Alimento>> result = dieta1.ottieniDieta();
        Map<String, List<Alimento>> result2 = dieta2.ottieniDieta();
    }
}

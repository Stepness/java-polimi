package exercises.generics.dieta2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dieta <T> {
    private Map<String, List<T>> programma;

    public Dieta(){
        programma = new HashMap<>();
    }

    public void aggiungiAlimento(String day, T alimento){
        List<T> alimenti = programma.get(day);
        if (alimenti == null){
            alimenti = new ArrayList<>();
            programma.put(day, alimenti);
        }
        alimenti.add(alimento);
    }

    public void rimuoviCibo(String day, T alimento){
        List<T> alimenti = programma.get(day);
        alimenti.remove(alimento);
    }

    public List<T> ottieniPasto(String day){
        return programma.get(day);
    }

    public Map<String, List<T>> ottieniDieta(){
        return programma;
    }
}

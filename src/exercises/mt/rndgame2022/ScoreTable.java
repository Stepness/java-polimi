package exercises.mt.rndgame2022;

import java.util.HashMap;
import java.util.Map;

public class ScoreTable {
    private Map<Integer, Integer> scores = new HashMap<>();
    private boolean isGameEnded = false;

    public synchronized int getScore(int id){
        return scores.get(id);
    }

    public synchronized void initializeScore(int id){
        scores.put(id, 0);
    }

    public synchronized void editScore(int id, int delta){
        int score = scores.get(id);
        scores.put(id, score+delta);

        if(delta>0 && scores.get(id) == 5){
            isGameEnded = true;
            System.out.println("Player number " + id + " WON!");
        }
    }

    public synchronized int getNumPlayers(){
        return scores.size();
    }

    public synchronized boolean isGameEnded(){
        return isGameEnded;
    }
}

package exercises.mt.rndgame2022;

import java.util.ArrayList;
import java.util.List;

public class Match {
    List<Player> players;
    ScoreTable scoreTable;

    public Match(int numPlayers){
        this.players = new ArrayList<>(numPlayers);
        this.scoreTable = new ScoreTable();

        for (int i = 1; i <= numPlayers; i++){
            scoreTable.initializeScore(i);
            players.add(new Player(i, this.scoreTable));
        }
    }

    public void start() throws InterruptedException {
        Thread[] threads = new Thread[players.size()];

        for(int i = 0; i < players.size(); i++){
            final int index = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    try {
                        while(!scoreTable.isGameEnded()){
                            players.get(index).play();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            threads[i].start();
        }

        for(Thread thread : threads){
            thread.join();
        }
    }
}

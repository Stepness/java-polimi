package exercises.mt.rndgame2022;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Bomb implements Runnable {

    Stato stato = Stato.IDLE;
    ScoreTable scoreTable;
    Player player;
    public int targetPlayer;

    public Bomb (ScoreTable scoreTable, Player player){
        this.player = player;
        this.scoreTable = scoreTable;
    }

    public void run() {
        stato = Stato.PENDING;
        Random rnd = new Random();
        int rndPlayerR;

        do{
            rndPlayerR = rnd.nextInt(2*scoreTable.getNumPlayers())+1;

            if(rndPlayerR > scoreTable.getNumPlayers()){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (rndPlayerR > scoreTable.getNumPlayers());

        targetPlayer = rndPlayerR;

        if (scoreTable.getScore(targetPlayer) > scoreTable.getScore(player.id)){
            stato = Stato.EXPLODED;
        }
        else {
            stato = Stato.UNEXPLODED;
        }

    }
}


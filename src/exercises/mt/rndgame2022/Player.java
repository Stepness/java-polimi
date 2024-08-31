package exercises.mt.rndgame2022;

import javax.sound.midi.SysexMessage;

public class Player {

    public int id;
    ScoreTable scoreTable;

    public Player(int id, ScoreTable scoreTable){
        this.id = id;
        this.scoreTable = scoreTable;
    }

    public void play() throws InterruptedException {
        Bomb bomb = new Bomb(scoreTable, this);
        Thread bombThread = new Thread(bomb);

        bombThread.start();
        bombThread.join();

        if (scoreTable.isGameEnded()){
            return;
        }

        if (bomb.stato == Stato.EXPLODED){
            System.out.println("Player " + bomb.targetPlayer + " hit " + id + "!");
            scoreTable.editScore(id, -1);
            scoreTable.editScore(bomb.targetPlayer, 1);
        }

        if (bomb.stato == Stato.UNEXPLODED){
            System.out.println("Player " + id + " hit " + bomb.targetPlayer + "!");
            scoreTable.editScore(id, 1);
            scoreTable.editScore(bomb.targetPlayer, -1);
        }
    }
}

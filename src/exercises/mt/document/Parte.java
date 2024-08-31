package exercises.mt.document;

public class Parte {

    private boolean busy;

    public synchronized boolean getSection(){
        if (busy){
            return false;
        }
        else{
            busy = true;
            return true;
        }
    }

    public synchronized void releaseSection(){
        busy = false;
    }
}


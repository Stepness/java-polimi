package patterns.state;

public abstract class State {

    public abstract void next(Phone phone);
    public abstract void handle();
}

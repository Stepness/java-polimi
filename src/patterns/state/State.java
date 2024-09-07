package patterns.state;

public interface State {

    public void next(Phone phone);
    public void handle();
}

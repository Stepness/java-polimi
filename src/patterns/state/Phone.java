package patterns.state;

public class Phone {
    State state = new OffState();

    public void action(){
        state.handle();
        state.next(this);
    }
}

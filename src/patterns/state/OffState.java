package patterns.state;

public class OffState implements State {

    public void next(Phone phone) {
        phone.state = new OnState();
    }

    public void handle() {
        System.out.println("Turning off");
    }
}

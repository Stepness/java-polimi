package patterns.state;

public class OnState implements State{

    public void next(Phone phone) {
        phone.state = new OffState();
    }

    public void handle() {
        System.out.println("Turning on");
    }
}

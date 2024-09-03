package patterns.state;

public class OffState extends State {

    public void next(Phone phone) {
        phone.state = new OnState();
    }

    public void handle() {
        System.out.println("Turning off");
    }
}

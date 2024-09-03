package patterns.state;

public class OnState extends State{

    public void next(Phone phone) {
        phone.state = new OffState();
    }

    public void handle() {
        System.out.println("Turning on");
    }
}

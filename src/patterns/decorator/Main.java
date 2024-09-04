package patterns.decorator;

public class Main {
    public static void main(String[] args) {


        INotifier notifier = new Notifier();
        notifier = new WhatsappDecorator(notifier);
        notifier = new FacebookDecorator(notifier);
        notifier.behaviour();
    }
}

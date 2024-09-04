package patterns.decorator;

public class FacebookDecorator extends BaseDecorator{

    public FacebookDecorator(INotifier notifier){
        super(notifier);
    }

    public void behaviour() {
        super.behaviour();
        System.out.println("ImFacebook");
    }
}

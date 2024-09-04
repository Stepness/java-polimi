package patterns.decorator;

public class BaseDecorator implements INotifier{

    private INotifier wrapped;

    public BaseDecorator(INotifier notifier){
        wrapped = notifier;
    }

    public void behaviour() {
        wrapped.behaviour();
    }
}

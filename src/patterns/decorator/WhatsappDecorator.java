package patterns.decorator;

import javax.annotation.processing.SupportedSourceVersion;

public class WhatsappDecorator extends BaseDecorator {

    public WhatsappDecorator(INotifier notifier){
        super(notifier);
    }

    public void behaviour() {
        super.behaviour();
        System.out.println("ImWhatsapp");
    }
}

package patterns.state;

import javax.crypto.Cipher;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.action();
        phone.action();
        phone.action();
    }
}

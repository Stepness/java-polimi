package exercises.mt.bank2022;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[3];
        BankAccount bankAccount = new BankAccount("Bob");
        BankAccount bankAccount2 = new BankAccount("George");

        Operator op = new Operator(bankAccount);
        Operator op2 = new Operator(bankAccount);
        Operator op3 = new Operator(bankAccount2);

        threads[0] = new Thread(op);
        threads[1] = new Thread(op2);
        threads[2] = new Thread(op3);

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            thread.join();
        }
    }
}

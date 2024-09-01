package exercises.mt.bank2022;

import java.util.Random;

public class Operator extends Thread{

    BankAccount bankAccount;

    public Operator(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

    public void run(){
        while(true){
            synchronized (bankAccount){
                int accountValue = bankAccount.getTotalAmount();
                if(accountValue>100){
                    bankAccount.withdraw((int) (accountValue*0.2));
                }
            }
            Random rnd = new Random();
            int rndValue = rnd.nextInt(20);
            bankAccount.deposit(rndValue);

            try {
                sleep(10000);
            } catch (InterruptedException e) {
            }
            
        }
    }
}

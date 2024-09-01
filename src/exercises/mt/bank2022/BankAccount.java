package exercises.mt.bank2022;

public class BankAccount {
    private int totalAmount;
    private String name;

    public BankAccount(String name){
        this.name = name;
    }

    public synchronized int withdraw(int amount){
        if(totalAmount<amount){
            int result = totalAmount;
            totalAmount = 0;
            System.out.println(this.name + " withdraws " + result);
            return result;
        }
        else{
            totalAmount -= amount;
            System.out.println(this.name + " withdraws " + amount);
            return amount;
        }
    }

    public synchronized void deposit(int amount){
        System.out.println( this.name + " deposits " + amount);
        totalAmount+=amount;
    }

    public synchronized int getTotalAmount(){
        System.out.println(this.name + " has  " + totalAmount);
        return totalAmount;
    }

}

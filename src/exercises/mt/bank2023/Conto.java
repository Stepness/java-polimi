package exercises.mt.bank2023;

public class Conto {
    private float saldo = 0;

    public synchronized void preleva(float prelievo){
        saldo-=prelievo;
    }

    public synchronized void deposita(float deposito){
        saldo+=deposito;
    }

    public synchronized float saldo(){
        return saldo;
    }
}

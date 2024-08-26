package exercises.mt.bank2023;

public class Banca {
    private float commissioni;

    public void presta(Conto a, Conto b, float prestito) throws Exception {
        synchronized (this){
            synchronized (a){
                synchronized (b){
                    if (a.saldo() > 2*prestito && b.saldo() > 3*prestito){
                        a.preleva(prestito);
                        commissioni += prestito*0.02f;
                        b.deposita(prestito*0.98f);
                    }
                    else{
                        throw new Exception("Prestito non possibile");
                    }
                }
            }
        }
    }
}

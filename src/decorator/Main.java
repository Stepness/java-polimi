package decorator;

public class Main {
    public static void main(String[] args) {
        ICar car = new Macchina();
        car = new MacchinaIncredibile(car);
        car = new MacchinaIncredibile(car);
        car = new MacchinaIncredibile(car);

        System.out.println(car.getDescrition());
    }
}

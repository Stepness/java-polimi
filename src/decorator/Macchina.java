package decorator;

public class Macchina implements ICar{
    @Override
    public String getDescrition() {
        return "ImaCar";
    }

    @Override
    public String getName() {
        return "Carrettino";
    }
}

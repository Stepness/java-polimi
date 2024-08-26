package decorator;

public class MacchinaIncredibile extends Description{

    public MacchinaIncredibile(ICar car) {
        super(car);
    }

    protected String More(){
        return "waaa";
    }
}

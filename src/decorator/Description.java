package decorator;

public abstract class Description implements ICar{

    private final ICar car;

    public Description(ICar car){
        this.car = car;
    }
    
    @Override
    public String getDescrition() {
        return car.getDescrition()+More();
    }


    @Override
    public String getName() {
        return car.getName();
    }

    protected abstract String More();
}

package interfaces.problem_02.car_shop_extendet;

public class CarImpl implements Car{

    String model;
    String color;
    Integer horsePower;
    String countryProduced;


    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires%n",
                getModel(), countryProduced(), TIRES, getModel());
    }
}

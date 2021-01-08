package interfaces.problem_02.car_shop_extendet;

public class Seat extends CarImpl implements Sellable{

    Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires%n%s sells for %f",
                getModel(), countryProduced(), TIRES, getModel(), getPrice());
    }

    @Override
    public Double getPrice() {
        return price;
    }
}

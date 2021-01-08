package interfaces.problem_02.car_shop_extendet;

public class Audi extends CarImpl implements Rentable{
    Integer minRentDay;
    Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced,
                Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires%n%s sells for %f",
                getModel(), countryProduced(), TIRES, getModel(), getPricePerDay());
    }
}

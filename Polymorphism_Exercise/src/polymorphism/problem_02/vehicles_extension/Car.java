package polymorphism.problem_02.vehicles_extension;

import java.text.DecimalFormat;

public class Car extends Vehicle{
    final private double AIR_CONDITIONER = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected String drive(double km) {
        double fuel = km * (getFuelConsumption() + AIR_CONDITIONER);
        if (fuel > getFuelQuantity()) {
            return "Car needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuel);
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String format = decimalFormat.format(km);
        return String.format("Car travelled %s km", format);
    }

    @Override
    protected void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(getFuelQuantity() + liters > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        setFuelQuantity(getFuelQuantity() + liters);
    }
}

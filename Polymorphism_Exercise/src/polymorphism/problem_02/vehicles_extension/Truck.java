package polymorphism.problem_02.vehicles_extension;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    final private double AIR_CONDITIONER = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected String drive(double km) {
        double fuel = km * (getFuelConsumption() + AIR_CONDITIONER);
        if (fuel > getFuelQuantity()) {
            return "Truck needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuel);
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String format = decimalFormat.format(km);
        return String.format("Truck travelled %s km", format);
    }

    @Override
    protected void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(getFuelQuantity() + liters > getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        setFuelQuantity(getFuelQuantity() + (liters * 0.95));
    }
}

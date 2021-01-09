package polymorphism.problem_01.vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected String drive(double km) {
        double fuel = km * (getFuelConsumption() + 1.6);
        if (fuel > getFuelQuantity()) {
            return "polymorphism.problem_02.vehicles_extension.Truck needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuel);
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String format = decimalFormat.format(km);
        return String.format("polymorphism.problem_02.vehicles_extension.Truck travelled %s km", format);
    }

    @Override
    protected void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + (liters * 0.95));
    }
}

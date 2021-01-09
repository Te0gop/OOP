package polymorphism.problem_01.vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected String drive(double km) {
        double fuel = km * (getFuelConsumption() + 0.9);
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
       setFuelQuantity(getFuelQuantity() + liters);
    }
}

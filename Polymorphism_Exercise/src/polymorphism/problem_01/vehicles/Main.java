package polymorphism.problem_01.vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));

        String[] truckData = scanner.nextLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] delimiter = scanner.nextLine().split(" ");
            String command = delimiter[0];
            String vehicle = delimiter[1];
            double distanceOrRefuel = Double.parseDouble(delimiter[2]);

            if(command.equals("Drive") && vehicle.equals("Car")) {
                System.out.println(car.drive(distanceOrRefuel));
            } else if (command.equals("Drive") && vehicle.equals("Truck")) {
                System.out.println(truck.drive(distanceOrRefuel));
            } else if (command.equals("Refuel") && vehicle.equals("Car")) {
                car.refuel(distanceOrRefuel);
            } else if (command.equals("Refuel") && vehicle.equals("Truck")) {
                truck.refuel(distanceOrRefuel);
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());

    }
}

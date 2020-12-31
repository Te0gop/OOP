package task_03_hotel;
import java.util.Scanner;

public class Calculator {

    protected static double calculateReservationPrice(Scanner scanner) {
        String[] reservation = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(reservation[0]);
        double numberOfDays = Integer.parseInt(reservation[1]);
        Seasons season = Seasons.valueOf(reservation[2].toUpperCase());
        Discounts discount = Discounts.valueOf(reservation[3]);

        return (pricePerDay * numberOfDays * season.getValue()) * discount.getValue();
    }
}

package inheritance.problem_04.vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(12, 90);

        car.drive(4);
        System.out.println(car.getFuel());
    }
}

package builder_pattern;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilderFacade()
                .info()
                    .withType("Honda")
                    .withColor("Grey")
                    .withNumberOfDoors(5)
                .built()
                    .inCity("Tokyo")
                    .atAddress("Honda str.")
                .build();
        System.out.println(car);
    }
}

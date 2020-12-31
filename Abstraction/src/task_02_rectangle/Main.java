package task_02_rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        PointOfRectangle leftBottom = new PointOfRectangle(coordinates[0], coordinates[1]);
        PointOfRectangle topRight = new PointOfRectangle(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(leftBottom, topRight);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            coordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            PointOfRectangle point2D = new PointOfRectangle(coordinates[0], coordinates[1]);

            boolean isContained = rectangle.contains(point2D);

            System.out.println(isContained);



        }
    }
}

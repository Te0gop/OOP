package encapsulation.problem_01.class_box;

import java.util.Scanner;
/*
You are given a geometric figure Box with fields length, width and height. Model a class Box that can be instantiated by the same three parameters. Expose to the outside world only methods for its surface area, lateral surface area and its volume (formulas: http://www.mathwords.com/r/rectangular_parallelepiped.htm).
On the first three lines you will get the length, width and height. On the next three lines print the surface area, lateral surface area and the volume of the box.
A box’s side should not be zero or a negative number. Add data validation for each parameter given to the constructor. Make a private setter that performs data validation internally.
Input	            Output
2                   Width cannot be zero or negative.
-3
4

2                   Surface Area - 52.00
3                   Lateral Surface Area - 40.00
4                   Volume – 24.00

1.3                 Surface Area - 30.20
1                   Lateral Surface Area - 27.60
6	                Volume - 7.80
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.println("Surface Area - " + box.calculateSurfaceArea());
            System.out.println("Lateral Surface Area - " + box.calculateLateralSurfaceArea());
            System.out.println("Volume – " + box.calculateVolume());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

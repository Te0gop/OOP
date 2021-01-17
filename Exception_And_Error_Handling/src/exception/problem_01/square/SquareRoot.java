package exception.problem_01.square;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int area;

        try {
            int side = Integer.parseInt(scanner.nextLine());
            area = side * side;
            System.out.println(area);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Good bye!");
        }

    }
}

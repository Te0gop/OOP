package exception.problem_02.numbers;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            int start = Integer.parseInt(scanner.nextLine());
            int end = Integer.parseInt(scanner.nextLine());
            System.out.println(printNumbers(start, end));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static int printNumbers(int start, int end) {
        Random random = new Random();
        int number = random.nextInt(100);
        if(number < start || number > end) {
            throw new IllegalArgumentException("Enter start and end numbers again.");
        }
        return number;
    }
}

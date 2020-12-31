package task_01_rhombus;

import java.util.Scanner;

public class RhombusOfStars {

    /*
    Create a program that reads a positive integer n as input and prints on the console a rhombus with size n:
input	            output
  3                    *
                      * *
                     * * *
                      * *
                       *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printRhombus('#', n);

    }

    private static void printRhombus(char symbol, int count) {
        for (int row = 1; row <= count; row++) {
            for (int spaces = 0; spaces < count - row; spaces++) {
                System.out.print(" ");
            }
            for (int stars = 0; stars < row; stars++) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        for (int row = 1; row <= count-1 ; row++) {
            for (int spaces = 0; spaces < row; spaces++) {
                System.out.print(" ");
            }
            for (int stars = 0; stars < count - row; stars++) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}

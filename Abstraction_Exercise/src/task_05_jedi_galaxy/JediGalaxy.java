package task_05_jedi_galaxy;

import java.util.Scanner;

public class JediGalaxy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        int num = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = num++;
            }
        }

        String jediCoordinates;
        String evilPowerCoordinates;
        int stars = 0;

        while (!(jediCoordinates = scanner.nextLine()).equals("Let the Force be with you")
            && !(evilPowerCoordinates = scanner.nextLine()).equals("Let the Force be with you")) {


            String[] evilPower = evilPowerCoordinates.split(" ");
            int evilPowerRow = Integer.parseInt(evilPower[0]);
            int evilPowerCol = Integer.parseInt(evilPower[1]);

            String[] jediPower = jediCoordinates.split(" ");
            int jediRow = Integer.parseInt(jediPower[0]);
            int jediCol = Integer.parseInt(jediPower[1]);

            evilPower(matrix, evilPowerRow, evilPowerCol);
            stars = collectStars(matrix, jediRow, jediCol);

        }
        System.out.println(stars);

    }

    private static void evilPower(int[][] matrix, int evilPowerRow, int evilPowerCol) {

        for (int i = evilPowerRow - 1; i >= 0; i--) {
            matrix[i][--evilPowerCol] = 0;
        }
    }

    private static int collectStars(int[][] matrix, int jediRow, int jediCol) {
        int stars = 0;
        for (int i = jediRow - 1; i >= 0; i--) {
            stars += matrix[i][++jediCol];
        }
        return stars;
    }

}

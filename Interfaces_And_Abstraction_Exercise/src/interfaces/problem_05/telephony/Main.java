package interfaces.problem_05.telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbersList = Arrays.asList(scanner.nextLine().split(" "));
        List<String> urlsList = Arrays.asList(scanner.nextLine().split(" "));

        Smartphone smartphone = new Smartphone(numbersList, urlsList);
        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());

    }
}

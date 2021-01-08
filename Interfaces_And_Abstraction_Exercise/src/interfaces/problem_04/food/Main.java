package interfaces.problem_04.food;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Citizen> citizens = new HashMap<>();
        Map<String, Rebel> rebels = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");

            if(data.length == 4) {
                Citizen citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
                citizens.put(citizen.getName(), citizen);
            } else {
                Rebel rebel = new Rebel(data[0], Integer.parseInt(data[1]), data[2]);
                rebels.put(rebel.getName(), rebel);
            }
        }

        String type;
        int food = 0;
        while (!(type = scanner.nextLine()).equals("End")) {
            if(citizens.containsKey(type)) {
                citizens.get(type).buyFood();
            } else if (rebels.containsKey(type)) {
                rebels.get(type).buyFood();
            }
        }
        for (Rebel value : rebels.values()) {
            food += value.getFood();
        }
        for (Citizen value : citizens.values()) {
            food += value.getFood();
        }

        System.out.println(food);
    }
}

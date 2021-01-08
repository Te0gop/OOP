package interfaces.problem_03.birthday;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new HashMap<>();

        String line;
        while (!(line = scanner.nextLine()).equals("End")) {
            String[] delimiter = line.split(" ");
            String type = delimiter[0];
            if(type.equals("interfaces.problem_03.birthday.interfaces.problem_04.food.Citizen")) {
                Citizen citizen = new Citizen(delimiter[1], Integer.parseInt(delimiter[2]),
                        delimiter[3], delimiter[4]);
                map.put(citizen.getName(), citizen.getBirthDate());
            } else if (type.equals("interfaces.problem_03.birthday.Pet")) {
                Pet pet = new Pet(delimiter[1], delimiter[2]);
                map.put(pet.getName(), pet.getBirthDate());
            }
        }
        String date = scanner.nextLine();

        map.forEach((key, value) -> {
            String[] split = value.split("/");
            if (split[2].equals(date)) {
                System.out.println(value);
            }
        });
    }
}

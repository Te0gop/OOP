package polymorphism.problem_03.wild_farm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;

        while (!(line = scanner.nextLine()).equals("End")) {
            String[] type = line.split("\\s+");
            String[] foodType = scanner.nextLine().split("\\s+");
            Animal animal = null;

            try {
                animal = determineTypeOfAnimal(type);
                animal.makeSound();
                animal.eat(checkFood(foodType));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(animal);
        }
    }

    private static Animal determineTypeOfAnimal(String[] type) {
        Animal animal = null;
        switch (type[0]) {
            case "Cat":
                animal = new Cat(type[0], type[1], Double.parseDouble(type[2]), type[3], type[4]);
                break;
            case "Tiger":
                animal = new Tiger(type[0], type[1], Double.parseDouble(type[2]), type[3]);
                break;
            case "Zebra":
                animal = new Zebra(type[0], type[1], Double.parseDouble(type[2]), type[3]);
                break;
            case "Mouse":
                animal = new Mouse(type[0], type[1], Double.parseDouble(type[2]), type[3]);
                break;
        }
        return animal;
    }

    private static Food checkFood(String[] s) {
        String food = s[0];
        int quantity = Integer.parseInt(s[1]);

        if(food.equals("Vegetable")) {
            return new Vegetable(quantity);
        }
        return new Meat(quantity);
    }
}

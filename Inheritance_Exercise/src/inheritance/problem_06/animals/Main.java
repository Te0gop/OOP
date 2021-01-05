package inheritance.problem_06.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfAnimal;
        Animal animal = null;
        List<Animal> animals = new ArrayList<>();

        while (!(typeOfAnimal = scanner.nextLine()).equals("Beast!")) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];
            try {
                switch (typeOfAnimal) {
                    case "inheritance.problem_06.animals.Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "inheritance.problem_06.animals.Kitten":
                        animal = new Kitten(name, age);
                        break;
                    case "inheritance.problem_06.animals.Tomcat":
                        animal = new Tomcat(name, age);
                        break;
                    case "inheritance.problem_06.animals.Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "inheritance.problem_06.animals.Frog":
                        animal = new Frog(name, age, gender);
                        break;
                }
                animals.add(animal);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (Animal a : animals) {
            System.out.println(a.getClass().getSimpleName());
            System.out.println(a);
            System.out.print(a.produceSound());
        }
    }

}

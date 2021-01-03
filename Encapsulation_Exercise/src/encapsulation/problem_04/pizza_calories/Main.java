package encapsulation.problem_04.pizza_calories;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] pizzaNameAndToppings = scanner.nextLine().split(" ");
            Pizza pizza = new Pizza(pizzaNameAndToppings[1], Integer.parseInt(pizzaNameAndToppings[2]));

            String[] pizzaDough = scanner.nextLine().split(" ");
            Dough dough = new Dough(pizzaDough[1], pizzaDough[2], Double.parseDouble(pizzaDough[3]));
            pizza.setDough(dough);

            String line;
            while (!(line = scanner.nextLine()).equals("END")) {
                String[] delimiter = line.split(" ");
                Topping topping = new Topping(delimiter[1], Double.parseDouble(delimiter[2]));
                pizza.addTopping(topping);
            }
            System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

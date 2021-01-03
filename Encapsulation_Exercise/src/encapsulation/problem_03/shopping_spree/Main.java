package encapsulation.problem_03.shopping_spree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
Create two classes: class Person and class Product. Each person should have a name, money and a bag of products. Each product should have name and cost.
Name cannot be an empty string. Be careful about white space in name. Money and cost cannot be a negative number.
Create a program in which each command corresponds to a person buying a product. If the person can afford a product add it to his bag. If a person doesn’t have enough money, print an appropriate message:
"{Person name} can't afford {Product name}"
On the first two lines you are given all people and all products. After all purchases print every person in the order of appearance and all products that he has bought also in order of appearance. If nothing is bought, print the name of the person followed by "Nothing bought".
Read commands till you find line with "END" command. In case of invalid input (negative money exception message: "Money cannot be negative") or empty name: (empty name exception message "Name cannot be empty") break the program with an appropriate message. See the examples below:
Input	                Output
Pesho=11;Gosho=4        Pesho bought Bread
Bread=10;Milk=2         Gosho bought Milk
Pesho Bread             Gosho bought Milk
Gosho Milk              Pesho can't afford Milk
Gosho Milk              Pesho - Bread
Pesho Milk              Gosho - Milk, Milk
END
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");

        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        for (String p : people) {
            String[] delimiter =  p.split("=");
            try {
                Person person = new Person(delimiter[0], Double.parseDouble(delimiter[1]));
                personList.add(person);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (String p : products) {
            String[] delimiter =  p.split("=");
            try {
                Product product = new Product(delimiter[0], Double.parseDouble(delimiter[1]));
                productList.add(product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String line;

        while (!(line = scanner.nextLine()).equals("END")) {
            String[] command = line.split(" ");
            String name = command[0];
            String productName = command[1];


            for (Person person : personList) {
                if(person.getName().equals(name)) {
                    for (Product product : productList) {
                        if (product.getName().equals(productName)) {
                            try {
                                person.buyProduct(product);
                                System.out.println(person.getName() + " bought " + product.getName());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }

            }
        }
        personList.forEach( person -> {
            if (person.getProducts().isEmpty()) {
                System.out.print(person.getName() + " - Nothing bought");
            } else {
                System.out.print(person.getName() + " - ");

                String joinedProducts = person.getProducts()
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));

                System.out.println(joinedProducts);
            }
        });






    }

}

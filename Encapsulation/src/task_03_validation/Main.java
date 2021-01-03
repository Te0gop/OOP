package task_03_validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
Expand Person with proper validation for every field:
•	Names must be at least 3 symbols
•	Age must not be zero or negative
•	Salary can't be less than 460.0
Print proper message to end user (look at example for messages).
Don't use System.out.println() in Person class.
Examples
Input	                        Output
5                               Age cannot be zero or negative integer
Asen Ivanov -6 2200             First name cannot be less than 3 symbols
B Borisov 57 3333               Last name cannot be less than 3 symbols
Ventsislav Ivanov 27 600        Salary cannot be less than 460 leva
Asen H 44 666.66                Ventsislav Ivanov gets 660.0 leva
Boiko Angelov 35 300
20
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            try {
                people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }

}

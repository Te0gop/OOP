package task_02_salary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
2.	Salary Increase
Read person with their names, age and salary. Read percent bonus to every person salary. People younger than 30 get half bonus. Expand Person from previous task. Add salary field and getter and setter with proper access.
New fields and methods
•	salary: double
•	increaseSalary(double bonus)
Examples
Input	                        Output
5                               Asen Ivanov gets 2640.0 leva
Asen Ivanov 65 2200             Boiko Borisov gets 3999.6 leva
Boiko Borisov 57 3333           Ventsislav Ivanov gets 660.0 leva
Ventsislav Ivanov 27 600        Asen Harizanoov gets 799.992 leva
Asen Harizanoov 44 666.66       Boiko Angelov gets 671.28 leva
Boiko Angelov 35 559.4
20
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }
        double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }

}

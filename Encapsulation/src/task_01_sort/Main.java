package task_01_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Create a class Person, which should have private fields for:
•	firstName: String
•	lastName: String
•	age: int
•	toString() - override
Examples
Input	                    Output
5                           Asen Harizanoov is 44 years old.
Asen Ivanov 65              Asen Ivanov is 65 years old.
Boiko Borisov 57            Boiko Angelov is 35 years old.
Ventsislav Ivanov 27        Boiko Borisov is 57 years old.
Asen Harizanoov 44          Ventsislav Ivanov is 27 years old.
Boiko Angelov 35
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }

        Collections.sort(people, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

}

package task_04_teams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
Create a Team class. Add to this team all person you read. All person younger than 40 go in first team, others go in reverse team. At the end print first and reserve team sizes.
The class should have private fields for:
•	name: String
•	firstTeam: List<Person>
•	reserveTeam: List<Person>
The class should have constructors:
•	Team(String name)
The class should also have private method for setName and public methods for:
•	getName(): String
•	addPlayer(Person person): void
•	getFirstTeam(): List<Person> (Collections.unmodifiableList)
•	getReserveTeam(): List<Person> (Collections.unmodifiableList)
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

        Team team = new Team("Black Eagles");
        for (Person person : people) {
            team.addPlayer(person);
        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }

}
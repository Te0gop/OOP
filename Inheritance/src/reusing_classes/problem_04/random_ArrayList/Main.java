package reusing_classes.problem_04.random_ArrayList;

import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        RandomArrayList list = new RandomArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println(list.getRandomElement());

    }
}

package task_01_card.suits;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        Arrays.stream(Suits.values()).forEach(s -> {
            System.out.println("Ordinal value: " + s.ordinal() +"; Name value: " + s.name());
        });



    }
}

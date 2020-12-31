package task_02_card.rank;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        Arrays.stream(Ranks.values()).forEach(s -> {
            System.out.println("Ordinal value: " + s.ordinal() +"; Name value: " + s.name());
        });
    }
}

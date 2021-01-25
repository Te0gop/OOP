package builder_pattern;

public class Main {
    public static void main(String[] args) {

        Item dagger = Item.builder()
                .name("Fel dagger")
                .attack(1000)
                .cost(15.99)
                .defence(1000)
                .health(100)
                .create();

        dagger = Item.builder(dagger)
                .attack(1250)
                .cost(1)
                .create();

        System.out.println(dagger);
    }
}

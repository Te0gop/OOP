package command_pattern;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void increasePrice(int amount) {
        setPrice(getPrice() + amount);
    }
    public void decreasePrice(int amount) {
        setPrice(getPrice() - amount);
    }

    @Override
    public String toString() {
        return String.format("Current price for the %s product is %d$.%n", name, price);
    }
}

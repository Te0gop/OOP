package encapsulation.problem_03.shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;


    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }
    public List<Product> getProducts() {
        return products;
    }

    private void setName(String name) {
        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    public void buyProduct(Product product) {
        if(money < product.getCost()) {
            throw new IllegalArgumentException(name + " can't afford " + product.getName());
        }
        money -= product.getCost();
        products.add(product);
    }

    public String getName() {
        return this.name;
    }

}

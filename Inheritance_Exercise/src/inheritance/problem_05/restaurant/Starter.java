package inheritance.problem_05.restaurant;

import java.math.BigDecimal;

public class Starter extends Food{
    public Starter(String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}

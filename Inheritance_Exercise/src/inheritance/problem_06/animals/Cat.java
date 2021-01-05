package inheritance.problem_06.animals;

public class Cat extends Animal{
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return "Meow meow";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

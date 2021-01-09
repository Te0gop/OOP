package polymorphism.problem_03.wild_farm;

public class Mouse extends Mammal{


    public Mouse(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if(!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
}

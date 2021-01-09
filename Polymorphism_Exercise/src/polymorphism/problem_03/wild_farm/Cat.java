package polymorphism.problem_03.wild_farm;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalType, String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }


    public String getBreed() {
        return breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
    @Override
    public String toString() {

        return  getAnimalType() + "["
                + getAnimalName() + ", "
                + getBreed() + ", "
                + getAnimalWeight() + ", "
                + getLivingRegion() + ", "
                + getFoodEaten() + "]";
    }
}

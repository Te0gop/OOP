package polymorphism.problem_03.wild_farm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }


    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String format = decimalFormat.format(getAnimalWeight());

        return  getAnimalType() + "["
                + getAnimalName() + ", "
                + format + ", "
                + getLivingRegion() + ", "
                + getFoodEaten() + "]";
    }

}

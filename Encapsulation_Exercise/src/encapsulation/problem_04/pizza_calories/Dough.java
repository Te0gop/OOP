package encapsulation.problem_04.pizza_calories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy")
                && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flour = 0;
        double technique = 0;

        switch (flourType) {
            case "White":
                flour = 1.5;
                break;
            case "Wholegrain":
                flour = 1.0;
                break;
        }
        switch (bakingTechnique) {
            case "Crispy":
                technique = 0.9;
                break;
            case "Chewy":
                technique = 1.1;
                break;
            case "Homemade":
                technique = 1.0;
                break;
        }

        return (2 * weight) * flour * technique;
    }
}

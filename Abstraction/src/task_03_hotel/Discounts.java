package task_03_hotel;

public enum Discounts {

    VIP(0.80),
    SecondVisit(0.90),
    None(1);

    double value;

    Discounts(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}

package task_03_hotel;

public enum Seasons {
    SPRING(2),
    SUMMER(4),
    AUTUMN(1),
    WINTER(3);

    int value;

    Seasons(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

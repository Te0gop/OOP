package encapsulation.problem_01.class_box;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private double getLength() {
        return length;
    }

    private void setLength(double length) {
        if(length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }

        this.length = length;
    }

    private double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if(width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if(height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea () {
        //2lw + 2lh + 2wh
        return 2 * (getLength() * getWidth()) + 2 * (getLength() * getHeight()) + 2 * (getWidth() * getHeight());
    }

    public double calculateLateralSurfaceArea() {
        //2lh + 2wh
        return 2 * (getLength() * getHeight()) + 2 * (getWidth() * getHeight());
    }

    public double calculateVolume() {
        // lwh
        return getLength() * getWidth() * getHeight();
    }
}


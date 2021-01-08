package polymorphism.problem_02.shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * radius;
    }

    @Override
    public double calculateArea() {
        return 2 * Math.PI * radius;
    }
}

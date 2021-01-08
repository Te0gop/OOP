package polymorphism.problem_02.shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(3);
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());

        Shape rectangle = new Rectangle(4, 4);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());
    }
}


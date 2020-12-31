package task_02_rectangle;

public class Rectangle {
    private PointOfRectangle bottomLeft;
    private PointOfRectangle topRight;

    public Rectangle(PointOfRectangle bottomLeft, PointOfRectangle topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(PointOfRectangle point2D) {
        return point2D.getX() >= bottomLeft.getX() && point2D.getX() <= topRight.getX()
                && point2D.getY() >= bottomLeft.getY() && point2D.getY() <= topRight.getY();
    }
}

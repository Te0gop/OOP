package task_02_rectangle;

public class PointOfRectangle {
    /*
    Create a class Point and a class task_02_rectangle.Rectangle. The Point should hold coordinates X and Y and the task_02_rectangle.Rectangle should
    hold 2 Points – its bottom left and top right corners. In the task_02_rectangle.Rectangle class, you should implement a
    contains(Point point) method that returns true or false, based on whether the Point given as attribute is
    inside or outside of the task_02_rectangle.Rectangle object. Points on the side of a Square are considered inside.
Input
•	On the first line read the coordinates of the bottom left and top right corner of the task_02_rectangle.Rectangle in the
format: “<bottomLeftX> <bottomLeftY> <topRightX> <topRightY>”.
•	On the second line, read an integer N and on the next N lines, read the coordinates of points.
Output
•	For each point, print out the result of the Contains() method.
Examples
input:          output:
0 0 3 3         true
5               true
0 0             false
0 1             false
4 4             true
5 3
1 2
     */

    private int x;
    private int y;

    public PointOfRectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

//205588940

import java.util.ArrayList;
import java.util.List;

/**
 * This class is about the Rectangle object.
 * A rectangle has an upper left point,width and height.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor.
     * @param upperLeft The upper left point.
     * @param width the width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Another constructor,with the x and y of the upper left pooint.
     * @param x the x of the upper left point.
     * @param y the y value of the upper left point.
     * @param width the width.
     * @param height the height.
     */
    public Rectangle(double x, double y, double width, double height) {
        this(new Point(x, y) , width, height);
    }

    /**
     * This method creates the rectangle line.
     * @return An array of the lines.
     */
    public Line[] recLines() {
        Point p1 = new Point(this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY());
        Point p2 = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight());
        Point p3 = new Point(p1.getX(), p2.getY());
        //upper horizonal line
        Line l1 = new Line(this.upperLeft, p1);
        //right line
        Line l2 = new Line(p1, p3);
        //bottom horizonal line
        Line l3 = new Line(p3, p2);
        //left line
        Line l4 = new Line(p2, this.upperLeft);
        Line[] lines = {l1, l2, l3, l4};
        return lines;
    }

    // Return a (possibly empty) List of intersection points
    // with the specified line.

    /**
     * This method return a list of the intersection points of the rectangle with a given line.
     * @param line A line.
     * @return an list of intersection points with the line. can be null.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //a flag for
        int flag = 1;
        //array will store the intersection points.
        List<Point> points = new ArrayList<Point>();
        //getting the rec lines.
        Line[] recLines = recLines();

        //The loop goes over each line and checking of he intersects with the given line.
        for (int i = 0; i < recLines.length; i++) {
            //if there is an intersection and points size > 0.
            if (recLines[i].isIntersecting(line)) {
                if (points.size() > 0) {
                    //if it already exsist in the list,updeate the flag to 0 so it will not be entered again.
                    for (int j = 0; j < points.size(); j++) {
                        if (points.get(j).equals(recLines[i].intersectionWith(line))) {
                            flag = 0;
                            break;
                        }
                    }
                }
                //if the point doesnt exsist in the list,add it.
                if (flag == 1) {
                    points.add(recLines[i].intersectionWith(line));
                }
                flag = 1;
            }
        }
        //returs the list.
        return points;
    }

    /**
     * This method is a getter for the rec width.
     * @return the rec width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * this method is a getter for the red height.
     * @return The rec height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * This method is a getter for the upperLeft point of the rec.
     * @return the rec's upper left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

}
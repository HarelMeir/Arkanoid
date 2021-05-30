//205588940

import java.util.List;
/**
 * This class will include the Line type data:
 * Fields,constructors and methods.
 * Move detailed info will be given for each part.
 */
public class Line {
    //fields
    private Point start;
    private Point end;
    // constructors

    /**
     * A constrator of a line using a starting and ending point.
     *
     * @param start the point the line starts at.
     * @param end   the point the line ends at.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * A second constructor using 4 double numbers represents 2 points.
     *
     * @param x1 the x value of the starting point.
     * @param y1 the y value of the strating point.
     * @param x2 the x value of the ending point.
     * @param y2 the y value of the ending point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this((new Point(x1, y1)), (new Point(x2, y2)));
    }

    /**
     * This methods gets the length of the line using the distance method from the Point class.
     *
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * This method gets the middle point of the line using getx and gety from the Point class.
     *
     * @return A point with the value of the middle point of the line.
     */
    public Point middle() {
        //Using the formula to cauculate the middle point from algebra.
        double xM = (this.start.getX() + this.end.getX()) / 2;
        double yM = (this.start.getY() + this.end.getY()) / 2;
        return new Point(xM, yM);
    }

    /**
     * This method gets the starting point of the line.
     *
     * @return a Point with the x and y value of the starting point of the line.
     */
    public Point start() {
        return new Point(this.start.getX(), this.start.getY());
    }

    /**
     * This method gets the ending point of the line.
     *
     * @return a Point with the x and the y values of the ending point of the line.
     */
    public Point end() {
        return new Point(this.end.getX(), this.end.getY());
    }

    /**
     * This methods finding the line slope.
     *
     * @return the line slope.
     */
    public double findM() {
        //A very small number to avoid dividing by 0.
        double likeNull = Math.pow(10, -10);
        //if the slope doesnt exsist.
        if (this.start.getX() == this.end.getX()) {
            return likeNull;
        }
        //if the slope is 0.
        if (this.start.getY() == this.end.getY()) {
            return 0;
        }
        //Using the formula to cauculate slope.
        return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }


    /**
     * The method returns 2 if the line interset with the other,and flase otherwise.
     *
     * @param other the other line.
     * @return true or false.
     */
    public boolean isIntersecting(Line other) {
        //if the lines are merging return false.
        if (this.equals(other) || other.equals(this)) {
            return false;
        }
        //an "ephsilon"
        double likeNull = Math.pow(10, -10);
        //the intersect point of the lines with y asix.
        double n1 = this.start.getY() - (this.findM() * this.start.getX());
        double n2 = other.start.getY() - (other.findM() * other.start.getX());
        //the x value of the intersection point between the 2 lines.
        double xI = (n2 - n1) / (this.findM() - other.findM());

        //if the first line has no slope,the only possible intersection point with the other line is at his x value.
        if (this.findM() == likeNull) {
            xI = this.start.getX();
            //if the other line has no slope,the only possible intersection point with the first line is at his x value.
        } else if (other.findM() == likeNull) {
            xI = other.start.getX();
        }


        //if the 2 lines are parallel,return false.
       if (this.findM() == other.findM() && n1 != n2) {
            return false;
        //if the lines are continuing each other,return true. else false.
        } else
        if (this.findM() == other.findM()) {
            if (this.start().equals(other.start()) || this.start().equals(other.end())
                    || this.end().equals(other.start()) || this.end().equals(other.end())) {
                return true;
            }
            return false;
        }

        double yI1 = (this.findM() * xI) + n1;
        double yI2 = (other.findM() * xI) + n2;
       if (this.findM() == likeNull && yI2 <= Math.max(this.start().getY(), this.end().getY())
               && yI2 >= Math.min(this.start.getY(), this.end().getY())) {
           yI1 = yI2;
       } else if (other.findM() == likeNull && yI1 <= Math.max(other.start().getY(), other.end().getY())
       && yI1 >= Math.min(other.start().getY() , other.end().getY())) {
           yI2 = yI1;
       }

        if (Math.max(this.start.getX(), this.end.getX()) >= xI && xI >= Math.min(this.start.getX(), this.end.getX())
                && Math.max(other.start.getX(), other.end.getX()) >= xI
                && xI >= Math.min(other.start.getX(), other.end.getX())) {
            if (Math.max(yI1, yI2) <= Math.min(yI1, yI2) + likeNull) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method returns the intersection point between 2 lines.
     *
     * @param other the other line.
     * @return the intersection point as a Point.
     */
    public Point intersectionWith(Line other) {
        double yI;
        //if the line indeed intersect
        if (this.isIntersecting(other)) {
            //an "ephsilon"
            double likeNull = Math.pow(10, -10);
            //the intersect point of the lines with y asix.
            double n1 = this.start.getY() - (this.findM() * this.start.getX());
            double n2 = other.start.getY() - (other.findM() * other.start.getX());

            //the x value of the intersection point between the 2 lines.
            double xI = (n2 - n1) / (this.findM() - other.findM());

            //if the 2 lines have no slope,update n1 and n2.
            if (this.findM() == likeNull && other.findM() == likeNull) {
                //if the intersetion point is at line 1 start:
                if (this.start().equals(other.start()) || this.start() == other.end()) {
                    xI = this.start.getX();
                    yI = this.start.getY();
                    return new Point(xI, yI);
                }
                //if the intersection point is at line 1 end:
                if (this.end().equals(other.start()) || this.end().equals(other.end())) {
                    xI = this.end.getX();
                    yI = this.end.getY();
                    return new Point(xI, yI);
                }

                //if this line has no slope,the intersection point will be on his x value.
            } else if (this.findM() ==  likeNull) {
                xI = this.start.getX();
                //find the y value of the other line in the intersection point.
                yI = (other.findM() * xI) + n2;
                return new Point(xI, yI);

                //if the other line has no slope,the intersection point will be in his x value.
            } else if (other.findM() == likeNull) {
                xI = other.start.getX();
                //find the y value of the other line in the intersection point.
                yI = (this.findM() * xI) + n1;
                return new Point(xI, yI);
            }
            //if the lines has slopes.
            yI = (this.findM() * xI) + n1;
            return new Point(xI, yI);
        }
        //if the lines does not intersect
        return null;
    }


    /**
     * This methods checking if 2 lines are equal.
     *
     * @param other the second line.
     * @return true if they are equal and false if they arent.
     */
    public boolean equals(Line other) {

        //if the starting and the ending point equals excatly between the lines,true. else false.


        if (this.start().equals(other.start()) && this.end().equals(other.end())) {
            return true;
        }
        return false;
    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.

    /**
     * This method returns the closest intersection point to the start of the line.
     * if it doesnt intersect, returns null.
     * @param rect a rectangle.
     * @return A intersection point, or null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line l = new Line(this.start, this.end);
        //a list of the intersectoin points with the line.
        List<Point> rectP = rect.intersectionPoints(l);
        //if the list is empty, there is no intersection and returns null.
        if (rectP.size() == 0) {
            return null;
        }

        Point closestPoint = rectP.get(0);
        //a variable that is the min distance from point to point.
       double minDistance = this.start().distance(closestPoint);
       // fiding the min distance and its index in the list.
        for (int i = 1; i < rectP.size(); i++) {
           double d = rectP.get(i).distance(this.start);
            if (d < minDistance) {
                minDistance = d;
                closestPoint = rectP.get(i);
            }
        }
        //return the point.
        return closestPoint;
        }
    }
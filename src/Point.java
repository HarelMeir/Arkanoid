//205588940

/**
 * This class will store the data about the Point type:
 * Fields, constructors and methods.
 * Everything will be further detailed before each part.
 */

public class Point {
    //Fields
    private double x;
    private double y;

    // constructor

    /**
     * A constructor,using x and y values of the point.
     * @param x the x value is wanted for the point.
     * @param y the y value is wanted for the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This methods cauculates the sqrt of: the power of  2 of the x1 - x2 plut the power of 2 of the y1-y2.
     * @param x1 the first point x value.
     * @param x2 the second point x value.
     * @param y1 the first point y value.
     * @param y2 the second point y value,
     * @return the sqrt result.
     */
    private double distanceHelperSqrt(double x1, double x2, double y1, double y2) {
     double result = Math.pow(Math.abs(x1 - x2), 2.0) + Math.pow(Math.abs(y1 - y2) , 2.0);
     return Math.sqrt(result);
    }

    /**
     * This methode will cauculate the distance between this point to a  given point,using distanceHelper method.
     * @param other the other point.
     * @return the distance between the points.
     */
    public double distance(Point other) {
       double x1 = this.x;
       double x2 = other.getX();
       double y1 = this.y;
       double y2 = other.getY();

       return distanceHelperSqrt(x1, x2, y1, y2);
    }

    /**
     * This method determains if this point equal to the other.
     * @param other the other point.
     * @return true if they are,false if they arent.
     */
    public boolean equals(Point other) {
        if (this.x == other.getX() && this.y == other.getY()) {
            return true;
        }
        return false;
    }

    /**
     * this method updates the x value of the point.
     * @param newX the new x value.
     * @return A point with updated x value.
     */
    public Point setX(double newX) {
        return new Point(newX, this.getY());
    }

    /**
     * this method updates the y value of the point.
     * @param newY the new y value.
     * @return A point with updated y value.
     */
    public Point setY(double newY) {
        return new Point(this.getX(), newY);
    }
    /**
     * This method will return this point's x value.
     * @return the x value.
     */
    public double getX() {
        return this.x;
    }

    /**
     * This method will return this point's y value.
     * @return the y value.
     */
    public double getY() {
        return this.y;
    }
}
//205588940


/**
 * This class will store the data about the Velocity type:
 * Fields, constractors and methods.
 */
public class Velocity {
    //Fields
    private double dx;
    private double dy;

    /**
     * A contractor using the dx and dy progress per step.
     * @param dx the progress in x asix per step.
     * @param dy the progress in y asix per step.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This method will return the dx.
     * @return the dx.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * This method will return the Dy.
     * @return dy.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * This method takes a point in position (x,y),
     * and returns the point in the (x+dx, y+dy).
     * @param p the point.
     * @return a point with the new values.
     */
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        double x1 = p.getX();
        double y1 = p.getY();
        double x2 = this.getDx();
        double y2 = this.getDy();
        return new Point(x1 + x2, y1 + y2);
    }

    /**
     * The method will get an angle and a speed,and will convert them into dx and dy.
     * @param angle The angle the ball will move at.
     * @param speed The speed the ball will move at.
     * @return a Velocity type with (dx,dy") values.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //convert the angle to radians.
        double angleRad = Math.toRadians(angle);
        //to cauculate the progress in x asix.
        double dx = speed * Math.sin(angleRad);
        //to cauculate the prograss in y asix.
        double dy = (-speed) * Math.cos(angleRad);
        return new Velocity(dx, dy);
    }
}
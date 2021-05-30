//205588940

/**
 * This class is the collisionInfo object. it holds the info about the collision point
 * and the collision object.
 * it includes all his fields,constructors and methods.
 */
public class CollisionInfo {
    //fields
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor.
     * @param collisionPoint the collision point.
     * @param collisionObject the collision object.
     * */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * constructor with x and y.
     * @param x the point's x.
     * @param y the point's y.
     * @param collisionObject the collision object.
     */
    public CollisionInfo(double x, double y, Collidable collisionObject) {
        this(new Point(x, y), collisionObject);
    }

    /**
     * A getter for the point which the collision happend with.
     * @return the collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * a getter for the object that the collision happened with.
     * @return the collision object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
//205588940

/**
 * This is an interface,other object in the program should implement.
 */
public interface Collidable {
    // Return the "collision shape" of the object.

    /**
     * This methode return the "collision shape" of the object.
     * @return the shape.
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * This This method adjust the velocity of the object according to his collision status.
     * @param hitter - The ball.
     * @param collisionPoint The collision point.
     * @param currentVelocity the current velocity of the object.
     * @return new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
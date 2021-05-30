//205588940

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * This class includes all the Ball type data:
 * Fields, 2 constructors,and methods.
 * A detailed explination will be given for each part.
 */
public class Ball implements Sprite {
    //Fields
    private int size;
    private java.awt.Color color;
    private Point center;
    private Velocity v;
    private  GameEnvironment gI;
    private List<HitListener> hitListeners;

    // constructor

    /**
     * this is a constructor building a ball using point,radius(size) and a color.
     * @param center the center point of the ball.
     * @param r the radius of the ball(size).
     * @param color the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.size = r;
        this.color = color;
    }

    /**
     * this a a second constructor. he points to the first constructor and used for x and y variabls.
     * @param x the x value of the center point.
     * @param y the y value of the center point.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this(new Point(x, y), r, color);
    }

    /**
     * new constructor with GameInviroment.
     * @param center the center point
     * @param r the radius
     * @param color the color.
     * @param gI the GameInviroment the ball's at with all the possibol colliders
     *
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gI) {
        this.center = center;
        this.size = r;
        this.color = color;
        this.gI = gI;
    }

    //methods
    /**
     * this method used for getting the x value of the center point.
     * @return the x value.
     */

    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * this method used for getting the y value of the center point.
     * @return the y value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * this method getting the size of the ball.
     * @return the size of the ball.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * this method getting the ball's color.
     * @return the color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * This method gets the GameEnviroment.
     * @return the ball's GameEnvorment
     */
    public GameEnvironment getgI() {
        return this.gI;
    }


    /**
     * this method darws the ball on a given draw surface.
     * @param surface the draw surface we want to draw the ball on.
     */
    public void drawOn(DrawSurface surface) {
        int x = getX();
        int y = getY();
        int r = getSize();
        surface.setColor(getColor());
        surface.fillCircle(x, y, r);
        surface.setColor(Color.BLACK);
        surface.drawCircle(x, y, r);

    }


    /**
     * this method setting the ball's velocity.
     * @param vel the velocity of the ball.
     */
    public void setVelocity(Velocity vel) {
        this.v = vel;
    }

    /**
     * this method setting the ball's velocity using dx and dy parameters.
     * @param dx the speed in the x axis.
     * @param dy the speed in the y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);

    }

    /**
     * this method getting the velocity of the ball.
     * @return the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * this method moving the ball one step according to  his velocity.
     */
  /*  public void moveOneStep() {
        this.center = this.getVelocity().applyToPoint(this.center);
    }*/

    /**
     * This method remove this ball from the game.
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * This method moving the ball one step according to his velocity.
     * if the ball intersects with an object,the ball will almost reach him,and his velocity
     * will be adjusted.
     */
    public void moveOneStep() {
        //an efsilon
        double efs = Math.pow(10, -3);

        //the velocities in each exis into variables
        double dxVel = this.getVelocity().getDx();
        double dyVel = this.getVelocity().getDy();

        //how the ball will move without any inturpution.
        Point ending = new Point(this.center.getX() + dxVel, this.center.getY() + dyVel);
        //our movement vector
        Line trajectory = new Line(this.center, ending);

        //if there isnt any collision, moveing the ball to the end of the vector.
        if (this.gI.getClosestCollision(trajectory) == null) {
            this.center = ending;
            return;
        }
        //getting the info about the closest collision
        CollisionInfo cI = this.gI.getClosestCollision(trajectory);

        //the intersection point
        Point inPoint = cI.collisionPoint();

        //promoting the ball until almost the collision point,considring the dx value.
        if (dxVel > 0) {
            this.center = this.center.setX(inPoint.getX() - efs);
        } else if (dxVel < 0) {
                this.center = this.center.setX(inPoint.getX() + efs);
            }
        //promoting the ball until almost the collision point,considring the dy value.
        if (dyVel < 0) {
            this.center = this.center.setY(inPoint.getY() + efs);
        } else if (dyVel > 0) {
            this.center = this.center.setY(inPoint.getY() - efs);
        }
        //adjusting the velocity upon hitting an object.
        Velocity ve = cI.collisionObject().hit(this, inPoint, this.getVelocity());
        this.setVelocity(ve.getDx(), ve.getDy());
        }

    /**
     * this method appplying movonestep.
     */
        public void timePassed() {
            this.moveOneStep();
        }

    /**
     * this method assing this ball to sprites list,and thus to the game object.
     * @param g A game objecte.
     */
    public void addToGame(GameLevel g) {
           g.addSprite(this);
        }
    }

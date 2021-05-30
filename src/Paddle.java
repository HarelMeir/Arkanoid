//205588940

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * This class is the paddle object. Its a rectangle that is part of the game and can be collided.
 * The paddle has a keyboard and a color.
 */

public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rec;
    private Color color;
    private int paddleMovement;

    /**
     * Constructor for paddle.
     * @param keyboard a keyboard for moving the paddle.
     * @param rec A rec whice is the shape of the paddle.
     * @param color The color of the paddle.
     * @param paddleMovement  - the paddle movment value.
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rec, Color color, int paddleMovement) {
        this.keyboard = keyboard;
        this.rec = rec;
        this.color = color;
        this.paddleMovement = paddleMovement;
    }

    /**
     * This method moving the Paddle left in x axis,by changing its upperLeft value to - PADDLEMOVEMENT.
     */
    public void moveLeft() {
        double dx = this.rec.getUpperLeft().getX() - this.paddleMovement;
        this.rec =  new Rectangle(new Point(dx, this.rec.getUpperLeft().getY()), this.rec.getWidth()
                , this.rec.getHeight());
    }

    /**
     * This method moving the Paddle right in x axis,by changing its upperLeft value to + PADDLEMOVEMENT.
     */
    public void moveRight() {
        double dx = this.rec.getUpperLeft().getX() + this.paddleMovement;
        this.rec = new Rectangle(new Point(dx, this.rec.getUpperLeft().getY()), this.rec.getWidth()
                , this.rec.getHeight());
    }

    /**
     * This is an overide from Sprite intecface.
     * This method moving the paddle according to the key pressed.
     */
    public void timePassed() {
        double rightPart = this.rec.getUpperLeft().getX() + this.rec.getWidth();
        double leftPart = this.rec.getUpperLeft().getX();
        //preventig the paddle going out the screen,considring the sides blocks.
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY) && rightPart + this.paddleMovement <= 775) {
            this.moveRight();
        }
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY) && leftPart - this.paddleMovement >= 25) {
            this.moveLeft();
        }
    }


    /**
     * This is override from Collidable interface.
     * This method return the collision "shape"
     * @return A rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    /**
     * This method cauculate the speef of the ball.
     * @param dx the velocity in x axis.
     * @param dy the velocity in y axis.
     * @return the speed.
     */
    public double getSpeed(double dx, double dy) {
        double powDx = Math.pow(dx, 2);
        double powDy = Math.pow(dy, 2);
        return Math.sqrt(powDx + powDy);
    }

    /**
     * A getter for the rectangle.
     * @return - this rectangle.
     */
    public Rectangle getRec() {
        return this.rec;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //the current velocity values.
        double curDX = currentVelocity.getDx();
        double curDY = currentVelocity.getDy();
        //the speed
        double speed = getSpeed(curDX, curDY);
        //the collision point values.
        double colX = collisionPoint.getX();
        double colY = collisionPoint.getY();
        //top left
        Point p1 = this.rec.getUpperLeft();
        //top right
        Point pEnd = new Point(p1.getX() + this.rec.getWidth(), p1.getY());
        //the size of each region
        double regionSize = (pEnd.getX() - p1.getX()) / 5;
        Point p2 = p1.setX(p1.getX() + regionSize);
        Point p3 = p2.setX(p2.getX() + regionSize);
        Point p4 = p3.setX(p3.getX() + regionSize);
        Point p5 = p4.setX(p4.getX() + regionSize);
        Line l = new Line(p1, p2);
        //if the collision happans in region 1
        if (colY == p1.getY()) {
            if (colX < p2.getX() && colX >= p1.getX()) {
                return Velocity.fromAngleAndSpeed(-60, speed);
            }
            //if the collision happens at region 2
            if (colX < p3.getX() && colX >= p2.getX()) {

                return Velocity.fromAngleAndSpeed(-30, speed);

            }
            //if the collision happens at region 3
            if (colX < p4.getX() && colX >= p3.getX()) {
                return new Velocity(curDX, -curDY);
            }
            //if the collision happens at region 4
            if (colX < p5.getX() && colX >= p4.getX()) {
                return Velocity.fromAngleAndSpeed(30, speed);
            }
            //if the collision happens in region 5
            return Velocity.fromAngleAndSpeed(60, speed);
        }

    //if the collision point is on the horizonal parts of the rect
        if (colY == p1.getY() || colY == p1.getY() + this.rec.getHeight()) {
        return new Velocity(curDX, -curDY);
    }

    //if the collision point is on the vertiacal parts of the rect
        if ((colX == p1.getX() || colX == p1.getX() + this.rec.getWidth())) {
        return new Velocity(-curDX, curDY);
    }
        //return the new velocity.
        return new Velocity(curDX, curDY);
    }


    /**
     * This method adding the paddle to a Game, by adding it to Sprite and Collidable lists.
     * @param g A game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * THis method draws the paddle on the drawSurface.
     * @param d The draw surface.
     */
    public void drawOn(DrawSurface d) {
        int x = (int) this.rec.getUpperLeft().getX();
        int y = (int) this.rec.getUpperLeft().getY();
        int width = (int) this.rec.getWidth();
        int height = (int) this.rec.getHeight();
        //drawing a paddle.
        d.setColor(this.color);
        d.fillRectangle(x, y, width, height);
        //drawing a black frame to the paddle
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, width, height);
    }
}
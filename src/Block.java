//205588940

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

/**
 * this class includes all Block's fields and methods.
 * the Block implements Collidable and Sprite(he is both).
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //field
    private Rectangle rec;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    //constuctors

    /**
     *Black constructor.
     * @param rec a rectangle,the shape of the bloak.
     * @param color his color.
     */
    public Block(Rectangle rec, java.awt.Color color) {
        this.rec = rec;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * another constructor with rectangle parts.
     * @param p upperleft
     * @param width rec width
     * @param height rec height
     * @param color rec color
     */
    public Block(Point p, double width , double height, java.awt.Color color) {
        this(new Rectangle(p, width , height), color);
    }
    /**
     * get the collision shape. a getter.
     * @return the collision shape.
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * This method notify all the listners that a hitEvent occured.
     * @param hitter the ball who hitted.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //assining the velocity values,and the collision point x and y into variables.
        double curDX = currentVelocity.getDx();
        double curDY = currentVelocity.getDy();
        double colX = collisionPoint.getX();
        double colY = collisionPoint.getY();
        //top left
        Point p1 = this.rec.getUpperLeft();
        //top right
        Point p2 = new Point(p1.getX() + rec.getWidth(), p1.getY());
        //bottom left
        Point p3 = new Point(p1.getX(), p1.getY() + rec.getHeight());
        //bottom right
        Point p4 = new Point(p2.getX(), p3.getY());
        //if the collision point is p1
        if (collisionPoint.equals(p1)) {
            this.notifyHit(hitter);
            //if it comes from upper left.
            if (curDX >= 0 && curDY >= 0) {
                return new Velocity(-curDX, -curDY);
                //if it come from up - right
            } else if (curDX < 0 && curDY > 0) {
                return new Velocity(curDX, -curDY);
                //if it comes from down left
            } else if (curDX > 0 && curDY < 0) {
                return new Velocity(-curDX, curDY);
            }
        }

        //the collision point is p2
        if (collisionPoint.equals(p2)) {
            this.notifyHit(hitter);
            //if it comes from upper -right
            if (curDX < 0 && curDY > 0) {
                return new Velocity(-curDX, -curDY);
                //if it comes from dont -right
            } else if (curDX < 0 && curDY < 0) {
                return new Velocity(-curDX, curDY);
                //if it comes from upper - left
            } else if (curDX > 0 && curDY > 0) {
                return new Velocity(curDX, -curDY);
            }
        }

        //if the collision point is p3
        if (collisionPoint.equals(p3)) {
            this.notifyHit(hitter);
            //if it comes from down - left
            if (curDX > 0 && curDY < 0) {
                return new Velocity(-curDX, -curDY);
                //if it come from up - right
            } else if (curDX > 0 && curDY > 0) {
                return new Velocity(-curDX, curDY);
                //if it comes from down - right
            } else if (curDX < 0 && curDY < 0) {
                return new Velocity(curDX, -curDY);
            }
        }

        //if the collision point is p4
        if (collisionPoint.equals(p4)) {
            this.notifyHit(hitter);
            //if it comes from down - right
            if (curDX < 0 && curDY < 0) {
                return new Velocity(-curDX, -curDY);
                //if it comes from down - left
            } else if (curDX > 0 && curDX < 0) {
                return new Velocity(curDX, -curDY);
                //if it comes from up - right
            } else if (curDX < 0 && curDY > 0) {
                return new Velocity(-curDX, curDY);
            }
        }
        //if the collision point is on the horizonal parts of the rect
        if (colY == p1.getY() || colY == p3.getY()) {
            this.notifyHit(hitter);
            return new Velocity(curDX, -curDY);
        }

        //if the collision point is on the vertiacal parts of the rect
        if ((colX == p1.getX() || colX == p2.getX())) {
            this.notifyHit(hitter);
            return new Velocity(-curDX, curDY);
        }
        //if it doesnt hit anything
        return currentVelocity;
    }

    /**
     * This method removes the blocks from the game.
     * @param game  - the game.
     */
    public  void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * this method drawing a block on a drawSurface.
     * @param surface The drwaing surface we want to draw on.
     */
    public void drawOn(DrawSurface surface) {
        int x = (int) this.rec.getUpperLeft().getX();
        int y = (int) this.rec.getUpperLeft().getY();
        int width = (int) this.rec.getWidth();
        int height = (int) this.rec.getHeight();
        surface.setColor(this.color);
        surface.fillRectangle(x, y, width, height);
        surface.setColor(Color.BLACK);
        surface.drawRectangle(x, y, width, height);
    }

    /**
     * this methode doing nothing for now.
     */
    public void timePassed() {
        ;
    }

    /**
     * the bloack is collidable and a sprite.
     * this method adding him to game object.
     * @param game our game object.
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

}

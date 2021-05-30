//205588940

import biuoop.DrawSurface;

/**
 * This is an interface of objects in the game.
 */
public interface Sprite {
    /**
     * this method darwing the sprite on the screen.
     * @param d The drawsurface.
     */
    void drawOn(DrawSurface d);

    /**
     * This method notify the Sprite that time has passed and he needs to perform another action.
     */
    void timePassed();
}
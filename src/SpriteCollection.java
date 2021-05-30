//205588940

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import biuoop.DrawSurface;

/**
 * This class is about the SpriteCollection object.
 * Its a list of sprites.
 */
public class SpriteCollection {
  private List<Sprite> sprites = new ArrayList<Sprite>();

    /**
     * conustrctor,intilzing a link list and assining it into this.
     */
    public SpriteCollection() {
        List<Sprite> sp = new LinkedList<Sprite>();
        this.sprites = sp;
    }

    /**
     * THis method adding a Sprite into the list.
     * @param s A sprite.
     */
    public void addSprites(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * This method remove sprite from the list.
     * @param s - sprite
     */
    public void removeSprites(Sprite s) {
        this.sprites.remove(s);
    }
    /**
     * This method activating timePassed() method on all the Sprites in the list.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprite = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : sprite) {
            s.timePassed();
        }
    }

    /**
     * This method gets the Sprites list size.
     * @return a number.
     */
    public int getSpriteColSize() {
        return this.sprites.size();
    }

    /**
     * This method calls the drawOn on all the Sprites in the list.
     * @param d A drawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
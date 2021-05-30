//205588940
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This class the info about Level 1 background.
 */
public class Level1Background implements Sprite {
    //memebers.
    private Rectangle rec;
    private String levelTitle;

    /**
     * Constructor.
     * @param rec - rectangle.
     */
    public Level1Background(Rectangle rec) {
        this.rec = rec;
        levelTitle = "Level name: Direct Hit";

    }

    @Override
    public void drawOn(DrawSurface d) {
        //the background
        d.setColor(Color.BLACK);
        d.drawText(500, 20, this.levelTitle, 15);
        //the text
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 40, 800, 560);
    }

    @Override
    public void timePassed() {
        ;
    }
}

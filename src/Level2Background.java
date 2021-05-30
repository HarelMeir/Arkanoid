//205588940
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class is level2 background info.
 */
public class Level2Background implements Sprite {
    //members
    private Rectangle rec;
    private String levelTitle;

    /**
     * Constructor.
     * @param rec - A rectangle.
     */
    public Level2Background(Rectangle rec) {
        this.rec = rec;
        levelTitle = "Level Name: Wide Easy";

    }

    @Override
    public void drawOn(DrawSurface d) {
        //the background
        d.setColor(Color.BLACK);
        d.drawText(500, 20, this.levelTitle, 15);
        //the text.
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 40, 800, 560);
    }

    @Override
    public void timePassed() {
        ;
    }
}
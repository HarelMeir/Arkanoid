//205588940
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class is level4 background info.
 */
public class Level4Background implements Sprite {
    //members.
    private Rectangle rec;
    private String levelTitle;

    /**
     * Constructor.
     * @param rec - a rectangle.
     */
    public Level4Background(Rectangle rec) {
        this.rec = rec;
        levelTitle = "Level Name: Final Four";

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(500, 20, this.levelTitle, 15);
        d.setColor(Color.blue.brighter());
        d.fillRectangle(0, 40, 800, 560);
    }

    @Override
    public void timePassed() {
        ;
    }
}
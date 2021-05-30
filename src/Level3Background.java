//205588940
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class is level 3 background info.
 */
public class Level3Background implements Sprite {
    //members.
    private Rectangle rec;
    private String levelTitle;

    /**
     * Constructor.
     * @param rec - rectangle.
     */
    public Level3Background(Rectangle rec) {
        this.rec = rec;
        levelTitle = "Level name: Green 3";

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(500, 20, this.levelTitle, 15);
        d.setColor(Color.green.darker());
        d.fillRectangle(0, 40, 800, 560);
    }

    @Override
    public void timePassed() {
        ;
    }
}
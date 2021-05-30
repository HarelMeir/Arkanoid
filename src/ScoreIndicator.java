//205588940
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class is a Sptrite that represent the score the player achived for the game.
 */
public class ScoreIndicator implements Sprite {
    //members
    private Counter score;
    private int x;
    private int y;
    private String str;
    private int fontSize;

    /**
      *
     * @param x the x value of the text.
     * @param y the y value of the text.
     * @param str the string.
     * @param fontSize the size of the font.
     * @param score the counter.
     */
    public ScoreIndicator(int x, int y, String str, int fontSize, Counter score) {
        this.x = x;
        this.y = y;
        this.str = str;
        this.fontSize = fontSize;
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(x, y, str + this.score.getValue() , fontSize);
    }

    @Override
    public void timePassed() {
        ;
    }

    /**
     * This method adds this to  the game.
     * @param game the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}

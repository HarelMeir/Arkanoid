//205588940
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This method is an winning animation.
 */
public class YouWin implements Animation {
    //members
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter finalScore;

    /**
     * Constructor.
     * @param k - a keyboard.
     * @param finalScore - a counter.
     */
    public YouWin(KeyboardSensor k, Counter finalScore) {
        this.keyboard = k;
        this.stop = false;
        this.finalScore = finalScore;
    }

    /**
     * A getter or the keyboard.
     * @return - a keyboard.
     */
    public KeyboardSensor getKeyboard() {
        return this.keyboard;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white.darker());
        d.fillRectangle(0,  0 ,  800,  600);
        d.setColor(Color.blue.darker());
        d.drawText(250, 200, "You Win!", 60);
        d.setColor(Color.red);
        d.drawText(280, 250 , "Your score is: " + this.finalScore.getValue(), 25);
    }

    @Override
    public boolean shouldStop() { return this.stop; }
}
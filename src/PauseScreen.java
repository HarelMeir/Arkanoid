//205588940
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This metod is an animation - pause screen.
 */
public class PauseScreen implements Animation {
    //members
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     * @param k - a keyboard.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * A getter for the keyboard.
     * @return - a keyboard.
     */
    public KeyboardSensor getKeyboard() {
        return this.keyboard;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLUE.darker());
        d.fillRectangle(0, 0 , 800, 600);
        //The text
        d.setColor(Color.yellow);
        d.drawText(d.getWidth() / 6, d.getHeight() / 2, "paused - press space to continue", 30);
    }
    @Override
    public boolean shouldStop() { return this.stop; }
}
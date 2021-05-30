//205588940
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * This class is the GAME OVER animation.
 */
public class GameOver implements Animation {
    //members
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter finalScore;

    /**
     * Constructor.
     * @param k - A keyboard.
     * @param finalScore - a counter for the final score.
     */
    public GameOver(KeyboardSensor k, Counter finalScore) {
        this.keyboard = k;
        this.stop = false;
        this.finalScore = finalScore;

    }

    /**
     * A getter for the keyboard.
     * @return - k eyboard sensor.
     */
    public KeyboardSensor getKeyboard() {
        return this.keyboard;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //the background of the animatoin.
        d.setColor(Color.white.darker());
        d.fillRectangle(0, 0 , 800, 600);
        //the text.
        d.setColor(Color.blue.darker());
        d.drawText(250, 200, "Game Over.", 50);
        d.setColor(Color.red);
        d.drawText(280, 250 , "your score is:" + this.finalScore.getValue(), 25);
    }

  @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
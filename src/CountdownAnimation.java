//205588940
import  biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * This class counting down from 3 to 1 before every level.
 */
public class CountdownAnimation implements Animation {
    //members
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Sleeper sleeper;
    private boolean stop;

    /**
     * Constructor.
     * @param numOfSeconds - the number of seconds.
     * @param countFrom - the number we countdown from.
     * @param gameScreen - the sprite collection.
     */
    public CountdownAnimation(double numOfSeconds , int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.sleeper = new Sleeper();
        this.stop = false;
    }

    /**
     * This method drawing the countdown on the screen.
     * @param d the drawsurface.
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.yellow.darker());
        d.drawText(370, 370, "" + this.countFrom, 50);
        if (countFrom != 3) {
            sleeper.sleepFor((long) ((this.numOfSeconds * 1000) / 3));
        }
        this.countFrom--;
        if (this.countFrom == -1) {
            this.stop = true;
        }
    }

    /**
     * This method returns if the animation should stop.
     * @return - true or false.
     */
    public boolean shouldStop() {
      return this.stop;
    }
}
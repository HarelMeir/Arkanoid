//205588940
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * this class is in charge of runnung the animations.
 */
public class AnimationRunner {
    //members
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Constructor.
     * @param gui - A gui;
     * @param framesPerSecond - the number of frames per second.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * A getter for gui.
     * @return this gui.
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * This method is the animation loop.
     * @param animation - The current animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 3000 / framesPerSecond;
        //the animation loop.
        while (!animation.shouldStop()) {
            //timing
            long startTime = System.currentTimeMillis();

            //creates a drawsurface.
            DrawSurface d = gui.getDrawSurface();;
            //do one frame of the animation.
            animation.doOneFrame(d);

            gui.show(d);
            //timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * This class is in charge of getting out of the animations screens.
 */

public class KeyPressStoppableAnimation implements Animation {
    //memebers
    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Constructor.
     * @param sensor - keyboard
     * @param key - a key
     * @param animation - the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        }
        isAlreadyPressed = false;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
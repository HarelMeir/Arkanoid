//205588940
import biuoop.DrawSurface;

/**
 * This interface for animation objects.
 * they will be activated on the draw surface and stopped.
 */
public interface Animation {
    /**
     * This method is activating one frame of the animation.
     * @param d the drawsurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * This tells us if the animation should stop.
     * @return true or false.
     */
    boolean shouldStop();
}
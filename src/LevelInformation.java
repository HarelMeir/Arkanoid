//205588940
import java.util.List;

/**
 * This interface in charge of the information of level in the game.
 */
public interface LevelInformation {
    /**
     * This method returns the numbers of balls in the level.
     * @return - a number.
     */
    int numberOfBalls();

    /**
     * This method returns the ball velocities.
     * @return - a velocity array.
     */
    List<Velocity> initialBallVelocities();

    /**
     * This method returns the paddle speed at the level.
     * @return - a number.
     */
    int paddleSpeed();

    /**
     * This method returns the paddle width.
     * @return a nubmer.
     */
    int paddleWidth();

    /**
     * This method returns the level name.
     * @return a string.
     */
    String levelName();

    /**
     * This method returns the level's background.
     * @return - a sprite.
     */
    Sprite getBackground();

    /**
     * This method returns a list of the level's blocks.
     * @return - block list.
     */
    List<Block> blocks();

    /**
     * This method returns the number of blocks that should be cleared in the level.
     * @return - a number.
     */
    int numberOfBlocksToRemove();

    /**
     * This method returns the paddle's upper left's x value.
     * @return a double number.
     */
     double paddleXUpperLeft();
}

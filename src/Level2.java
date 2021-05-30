//205588940
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the level 2 info.
 */
public class Level2 implements LevelInformation {
    //members
    private int ballsNumber;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int remainingBlocks;

    /**
     * Constructor.
     */
    public Level2() {
        this.ballsNumber = this.numberOfBalls();
        this.initialBallVelocities = initialBallVelocities();
        this.paddleSpeed = paddleSpeed();
        this.paddleWidth = paddleWidth();
        this.levelName = levelName();
        this.background = getBackground();
        this.blocks = blocks();
        this.remainingBlocks = numberOfBlocksToRemove();
    }

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        for (int i = 1; i < this.numberOfBalls() + 1; i++) {
            velocities.add(Velocity.fromAngleAndSpeed((-30 + i * 6), 15));
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 525;
    }

    @Override
    public String levelName() {
        return new String("Level 2");
    }

    @Override
    public Sprite getBackground() {
        return new Level2Background(new Rectangle(0, 40, 800, 560));
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocksList = new ArrayList<Block>();
        //creating a line of blocks
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            Color color = Color.red;
                if (i < 2) {
                    color = Color.red;
                } else if (i < 4) {
                    color = Color.orange;
                } else if (i < 6) {
                    color = Color.yellow;
                } else if (i < 9) {
                    color = Color.green;
                } else if (i < 11) {
                    color = Color.blue;
                } else if (i <  13) {
                    color = Color.pink;
                } else if (i < 15) {
                    color = Color.cyan;
                }
                Block b = new Block(new Rectangle(25 + (i * 50), 250, 50, 25), color);
                blocksList.add(b);
        }
        return blocksList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

    @Override
    public double paddleXUpperLeft() {
        return 125;
    }
}

//205588940
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the level 1 info.
 */
public class Level1 implements LevelInformation {
    //members.
    private int ballsNumber;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int remainingBlocks;
    private double paddleX;

    /**
     * Constructor.
     */
    public Level1() {
        this.ballsNumber = this.numberOfBalls();
        this.initialBallVelocities = initialBallVelocities();
        this.paddleSpeed = paddleSpeed();
        this.paddleWidth = paddleWidth();
        this.levelName = levelName();
        this.background = getBackground();
        this.blocks = blocks();
        this.remainingBlocks = numberOfBlocksToRemove();
        this.paddleX = paddleXUpperLeft();
    }

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            velocities.add(new Velocity(0, -20));
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 25;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return new String("Level 1");
    }

    @Override
    public Sprite getBackground() {
        return new Level1Background(new Rectangle(0, 40, 800, 560));
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockss = new ArrayList<Block>();
        Block b = new Block(new Rectangle(385, 150, 35, 35), Color.RED);
        blockss.add(b);
        return blockss;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }

    @Override
    public double paddleXUpperLeft() {
        return 350;
    }
}

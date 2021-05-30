//205588940
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is level3 info.
 */
public class Level3 implements LevelInformation {
    //members
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
    public Level3() {
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
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            velocities.add(Velocity.fromAngleAndSpeed(-30 + (i * 60),  10 - (i * 0.5)));
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
        return new String("Level 3");
    }

    @Override
    public Sprite getBackground() {
        return new Level3Background(new Rectangle(0, 40, 800, 560));
    }

    @Override
    public List<Block> blocks() {
        //creates lines of blocks with random colors and adds them the list.
        List<Block> blockss = new ArrayList<Block>();
        int k = 10;
        //creating a chosen lines of blocks.
        for (int i = 0; i < 5; i++) {
            //generating random color
            Color color = GameLevel.rColor();
            //each line will have 1 less block than the previous.
            for (int j = 0; j < k; j++) {
                Block b = new Block(new Rectangle(725 - (j * 50), 150 + (i * 25), 50, 25), color);
                blockss.add(b);
            }
            //for 1 less block in next line
            k--;
        }

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

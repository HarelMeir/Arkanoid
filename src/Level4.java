//205588940
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is level 4 info.
 */
public class Level4 implements LevelInformation {
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
     * constructor.
     */
    public Level4() {
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
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            velocities.add(Velocity.fromAngleAndSpeed(-60 + (i * 60), 10 + ((i + 1) * 5)));
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
        return new String("Level 4");
    }

    @Override
    public Sprite getBackground() {
        return new Level4Background(new Rectangle(0, 40, 800, 560));
    }

    @Override
    public List<Block> blocks() {
        //creates lines of bloack in random colors and adding them to the game.
        List<Block> blockss = new ArrayList<Block>();
        //creating a chosen lines of blocks.
        for (int i = 0; i < 7; i++) {
            //generating random color
            Color color = GameLevel.rColor();
            //each line will have 1 less block than the previous.
            for (int j = 0; j < 15; j++) {
                Block b = new Block(new Rectangle(25 + (j * 50), 130 + (i * 25), 50, 25), color);
                blockss.add(b);
            }
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

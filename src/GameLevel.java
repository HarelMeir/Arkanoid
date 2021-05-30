//205588940

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.Random;
import java.util.List;

/**
 * This class includes all the game data:
 * the objects inside it,the collidable objects and the gui.
 * it intializing and runes the game.
 */
public class GameLevel implements Animation {
    //fields
     private SpriteCollection sprites;
     private GameEnvironment environment;
     private Counter remainBlocks;
     private Counter remainingBalls;
     private Counter score;
     private AnimationRunner runner;
     private boolean running;
     private PauseScreen pauseScreen;
     private LevelInformation level;
    private YouWin win;


     //finals for block width,height,and number of lines of blocks.
    private static final int BWIDTH = 50;
    private static final int BHEIGHT = 20;
    private static final int NUMBEROFLINES = 6;

    /**
     * Constuctor.
     * @param level - The current level.
     * @param runner - an Animation runner.
     * @param keyboard - a keyboard sensor.
     * @param score - the score of the player.
     */
    public GameLevel(LevelInformation level, AnimationRunner runner, KeyboardSensor keyboard, Counter score) {
        SpriteCollection sp = new SpriteCollection();
        this.sprites = sp;
        GameEnvironment ga = new GameEnvironment();
        this.level = level;
        this.environment = ga;
        this.remainBlocks = new Counter(level.numberOfBlocksToRemove());
        this.remainingBalls = new Counter(level.numberOfBalls());
        this.score = score;
        this.running = true;
        this.runner = runner;
        this.pauseScreen = new PauseScreen(this.runner.getGui().getKeyboardSensor());


    }


    /**
     * this method removes a collidable from the game.
     * @param c - collidable.
     */
   public void removeCollidable(Collidable c) {
        this.environment.removeCollidble(c);
    }

    /**
     * This method remove Sprite from the game.
     * @param s - a Sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprites(s);
    }

    /**
     * adding a collidale into game(enviroment list).
     * @param c the collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Adding a sprite into the game(sprites list).
     * @param s the sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprites(s);
    }
    /**
     * This method generating a random color.
     * @return random color.
     */
    public static Color rColor() {
        //creates a random generator.
        Random rColor = new Random();
        Color color = new Color(rColor.nextInt(255), rColor.nextInt(255), rColor.nextInt(255));
        return color;
    }

    /**
     * A getter for the remain blocks of the level.
     * @return a number.
     */
    public Counter getRemainBlocks() {
        return remainBlocks;
    }

    /**
     * A getter for the animation runner.
     * @return an animation runner.
     */
    public AnimationRunner getRunner() {
        return this.runner;
    }

    /**
     * A getter for level info.
     * @return  this level info.
     */
    public LevelInformation getLevel() {
        return this.level;
    }
    /**
     * A getter for the score.
     * @return - score counter.
     */
    public Counter getScore() {
        return score;
    }

    /**
     * This method creats the balls of the level.
     */
    public void createBalls() {
        //creates a list of velocities of the level.
        List<Velocity> velocities = level.initialBallVelocities();
        int j = level.numberOfBalls();
        //creating the balls close to the paddle.
        double ballX = this.level.paddleXUpperLeft() + this.level.paddleWidth() / 2;
        double ballY = 570;

        //creats all the balls of the level.
        for (int i = 0; i < j; i++) {
            Ball b = new Ball(new Point(ballX, ballY), 5, Color.white, this.environment);
            b.setVelocity(velocities.get(i).getDx(), velocities.get(i).getDy());
            b.addToGame(this);
        }
    }



    /**
     * A getter for the remaning balls.
     * @return the remaning balls.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }
    /**
     *This methode intializing the game:
     * it creates a giu,the balls, the paddle and the blocks.
     */
    public void initialize() {
        //creates a keyboard
        biuoop.KeyboardSensor keyboard = this.runner.getGui().getKeyboardSensor();

        //creats a BlockRemover
        BlockRemover blockR = new BlockRemover(this, remainBlocks);
        //creats a BallRemover
        BallRemover ballR = new BallRemover(this);
        //creats score tracking listner.
        ScoreTrackingListener scoreL = new ScoreTrackingListener(this.score);

        //creats score indicator.
        ScoreIndicator sD = new ScoreIndicator(100, 20, "score: " , 15, this.score);
        sD.addToGame(this);

        this.addSprite(this.level.getBackground());
        //Sprite s = this.level.getBackground();

        //creates the paddal at the bottom of the surface.
        Paddle ped = new Paddle(keyboard, new Rectangle(level.paddleXUpperLeft(), 580, level.paddleWidth(), 10)
                , Color.YELLOW, level.paddleSpeed());
        ped.addToGame(this);

        createBalls();
        //creates the  frame blocks:
        //up block
        Block blockUp = new Block(new Point(0, 25), 800, 30, Color.GRAY);
        blockUp.addToGame(this);

        //left block
        Block blockLeft = new Block(new Point(0, 0), 25, 600 , Color.GRAY);
        blockLeft.addToGame(this);

        //right block
        Block blockRight = new Block(new Point(775, 0), 25, 600, Color.GRAY);
        blockRight.addToGame(this);

        //killing block
        Block blockDown = new Block(new Point(0, 610), 1000, 30, Color.GRAY);
        blockDown.addHitListener(ballR);
        blockDown.addToGame(this);
        //the list of blocks
        List<Block> blockss = this.level.blocks();

        //creating the blocks of the level and adding them to game.
        for (int j = 0; j < level.numberOfBlocksToRemove(); j++) {
          Block b = blockss.get(j);
          b.addToGame(this);
          b.addHitListener(blockR);
          b.addHitListener(scoreL);
        }
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //the level keyboard.
        KeyboardSensor levelK = this.runner.getGui().getKeyboardSensor();

        //pause screen activation.
        if (this.pauseScreen.getKeyboard().isPressed("p")) {
            KeyPressStoppableAnimation kps = new KeyPressStoppableAnimation(levelK, "SPACE_KEY", this.pauseScreen);
            this.runner.run(kps);
        }
        //if the player finishing the level, stop the loop and ass 100 points.
        if (this.remainBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        //if the player lost stop the loop.
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
        //draw and activate all the sprites.
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * This method runs the game.
     */

    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }
}
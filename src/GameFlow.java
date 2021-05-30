//205588940
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * This class is in charge of the game flow and levels.
 */
public class GameFlow {
    //memebers.
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter overallScore;
    private GameOver game;

    /**
     * Constructor.
     * @param ar - an anomation runner.
     * @param ks - a keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.overallScore = new Counter(0);
    }

    /**
     * This method in charge of running the levels.
     * @param levels - The level's list.
     */
    public void runLevels(List<LevelInformation> levels) {
        //counter for the stop condition.
        int count = 0;
        //running over all the levels in the list.
        for (LevelInformation levelInfo : levels) {
            //creats a game level from the array.
            GameLevel level = new GameLevel(levelInfo, this.ar, this.ks, this.overallScore);
            //initialize it
            level.initialize();

            //if the player hasnt lost and the level hasnt finished, run the level.
            while (level.getRemainingBalls().getValue() > 0 && level.getRemainBlocks().getValue() > 0) { ;
                level.run();
                count++;
                //keeps score across levels.
                this.overallScore = level.getScore();
            }
            //creates keyboard.
            KeyboardSensor levelK = level.getRunner().getGui().getKeyboardSensor();

            //if the player lost
            if (level.getRemainingBalls().getValue() == 0) {
                //creats a gameOver animation and runes it.
                GameOver gameOver = new GameOver(levelK, this.overallScore);
                KeyPressStoppableAnimation kps = new KeyPressStoppableAnimation(levelK, "SPACE_KEY", gameOver);
                level.getRunner().run(kps);
                //closing the game and getting out of the loop.
                level.getRunner().getGui().close();
                break;
            }

            //if the player won
            if (count == levels.size()) {
                //creates a winning animation and runs it.
                YouWin win = new YouWin(level.getRunner().getGui().getKeyboardSensor(), this.overallScore);
                KeyPressStoppableAnimation kps = new KeyPressStoppableAnimation(levelK, "SPACE_KEY", win);
                level.getRunner().run(kps);
                //closing the gui.
                level.getRunner().getGui().close();
            }
        }
    }
}
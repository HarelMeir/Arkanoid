//205588940
import java.util.List;
import java.util.ArrayList;
import  biuoop.GUI;
/**
 * this class responsible to activate the game using its methods.
 */
public class Ass6Game {
    /**
     * main method.
     *
     * @param args array that doesnt been used.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    levels.add(new Level1());
                }
                if (args[i].equals("2")) {
                    levels.add(new Level2());
                }
                if (args[i].equals("3")) {
                    levels.add(new Level3());
                }
                if (args[i].equals("4")) {
                    levels.add(new Level4());
                }
            }
        }
        if (levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }


        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner ar = new AnimationRunner(gui, 60);
        GameFlow letsplay = new GameFlow(ar, ar.getGui().getKeyboardSensor());
        letsplay.runLevels(levels);
    }
}
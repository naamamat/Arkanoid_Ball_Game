// 322316506 Naama Matzliach

import biuoop.GUI;

import gameSystem.AnimationRunner;
import gameSystem.GameFlow;
import levels.LevelInformation;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;
import levels.LevelFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The class Ass6Game.
 * For start the game.
 * @author Naama Matzliach
 */
public class Ass6Game {
    private static final int FRAMES_PER_SECOND = 60;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /** The main method.
     * Creates the enviroment game.
     * @param args unused
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Game", WIDTH, HEIGHT);
        AnimationRunner runner = new AnimationRunner(gui, FRAMES_PER_SECOND);
        GameFlow gameFlow = new GameFlow(runner, gui.getKeyboardSensor(), WIDTH, HEIGHT);

        List<LevelInformation> levels = getLevelsFromArgs(args);
        if (levels.isEmpty()) {
            levels = Arrays.asList(new LevelInformation[]{
                    new LevelOne(WIDTH, HEIGHT),
                    new LevelTwo(WIDTH, HEIGHT),
                    new LevelThree(WIDTH, HEIGHT),
                    new LevelFour(WIDTH, HEIGHT)
            });
        }

        gameFlow.runLevels(levels);
        gui.close();
    }

    /**
     * Get the levels in list from string args.
     * @param args The levels string
     * @return The list of levels
     */
    public static List<LevelInformation> getLevelsFromArgs(String[] args) {
        List<LevelInformation> levels = new ArrayList<LevelInformation>();

        for (int i = 0; i < args.length; i++)   {
            if (!isInteger(args[i])) {
                continue;
            }


            int level = Integer.parseInt(args[i]);

            switch (level) {
                case 1:
                    levels.add(new LevelOne(WIDTH, HEIGHT));
                    break;
                case 2 :
                    levels.add(new LevelTwo(WIDTH, HEIGHT));
                    break;
                case 3:
                    levels.add(new LevelThree(WIDTH, HEIGHT));
                    break;
                case 4:
                    levels.add(new LevelFour(WIDTH, HEIGHT));
                    break;
                default:
                    break;
            }
        }

        return levels;
    }

    /**
     * Check if string is integer.
     * @param s The string
     * @return True if integer.
     */
    public static boolean isInteger(String s) {
        if (s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (Character.digit(s.charAt(i), 10) < 0) {
                return false;
            }

        }
        return true;
    }
}

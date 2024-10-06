// 322316506 Naama Matzliach
package gameSystem;

import biuoop.KeyboardSensor;
import levels.LevelInformation;

import java.util.List;

/**
 * The GameFlow class.
 * Runs all the levels of the game.
 * @author Naama Matzliach
 */
public class GameFlow {
    private KeyboardSensor keyboard;
    private AnimationRunner runner;
    private int gameWidth;
    private int gameHeight;

    /**
     * Constructor.
     * @param runner The animation runner.
     * @param keyboard The keyboard of gui.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public GameFlow(AnimationRunner runner, KeyboardSensor keyboard, int gameWidth, int gameHeight) {
        this.runner = runner;
        this.keyboard = keyboard;
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
    }

    /**
     * Run all the levels of the game.
     * @param levels The levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter score = new Counter();
        boolean isWin = true;

        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo,
                    this.keyboard,
                    this.runner,
                    score,
                    gameWidth,
                    gameHeight);

            level.initialize();
            level.run();

            if (level.getRemainingBalls() == 0) {
                isWin = false;
                break;
            }
        }

        runner.run(new KeyPressStoppableAnimation(
                keyboard,
                KeyboardSensor.SPACE_KEY,
                new EndScreen(score.getValue(), isWin)));
    }
}

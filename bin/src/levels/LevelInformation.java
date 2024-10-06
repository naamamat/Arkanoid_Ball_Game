// 322316506 Naama Matzliach
package levels;

import gameSystem.Block;
import gameSystem.Velocity;
import gui.Sprite;

import java.util.List;

/**
 * The LevelInformation interface.
 * Contains the level information.
 * @author Naama Matzliach
 */
public interface LevelInformation {
    /**
     * @return The number of balls.
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls().
     * @return The velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return The paddle speed.
     */
    int paddleSpeed();

    /**
     * @return The paddle width.
     */
    int paddleWidth();

    /**
     * The level name will be displayed at the top of the screen.
     * @return The name.
     */
    String levelName();

    /**
     * @return Sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return The blocks.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return The number of blocks to remove
     */
    int numberOfBlocksToRemove();
}
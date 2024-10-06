// 322316506 Naama Matzliach
package levels;

import backgrounds.Background;
import backgrounds.LevelOneBackground;
import gameSystem.*;
import geometryPrimitives.Point;
import geometryPrimitives.Rectangle;
import gui.Sprite;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

/**
 * The LevelOne class.
 * Contains the level information.
 * @author Naama Matzliach
 */
public class LevelOne implements LevelInformation {
    private Background background;
    private List<Block> blocks;
    private List<Velocity> ballsVelocities;

    /**
     * Constructor.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public LevelOne(int gameWidth, int gameHeight) {
        background = new LevelOneBackground(Color.BLACK, gameWidth, gameHeight);
        blocks = Arrays.asList(new Block[] {
                new Block(new Rectangle(new Point(gameWidth / 2 - 30 / 2, gameHeight /4),
                        30, 30), Color.RED) });
        ballsVelocities = Arrays.asList(new Velocity[] {
                Velocity.fromAngleAndSpeed(0, 5) });
    }

    @Override
    public int numberOfBalls() {
        return ballsVelocities.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return ballsVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 20;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return background;
    }

    @Override
    public List<Block> blocks() {
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks.size();
    }
}
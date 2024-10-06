// 322316506 Naama Matzliach
package levels;

import backgrounds.Background;
import backgrounds.LevelThreeBackground;
import gameSystem.Block;
import gameSystem.Velocity;
import geometryPrimitives.Point;
import geometryPrimitives.Rectangle;
import gui.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The LevelThree class.
 * Contains the level information.
 * @author Naama Matzliach
 */
public class LevelThree implements LevelInformation {
    private Background background;
    private List<Block> blocks;
    private List<Velocity> ballsVelocities;

    private static final int BLOCK_WIDTH = 50;
    private static final int BLOCK_HEIGHT = 25;
    private static final int SPEED = 8;
    private static final int NUM_OF_LINES = 5;
    private static final int START_LINE = 5;
    private static final int NUM_OF_BLOCKS_IN_FIRST = 10;

    /**
     * Constructor.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public LevelThree(int gameWidth, int gameHeight) {
        background = new LevelThreeBackground(Color.GREEN, gameWidth, gameHeight);
        blocks = new ArrayList<>();
        Color[] colors = {Color.GRAY, Color.RED, Color.ORANGE, Color.YELLOW, Color.BLUE };

        for (int i = START_LINE; i < START_LINE + NUM_OF_LINES; i++) {
            double y = i * BLOCK_HEIGHT;
            for (int j = i; j < START_LINE + NUM_OF_BLOCKS_IN_FIRST; j++) {
                double x = (gameWidth - 25) - ((j - i + 1) * BLOCK_WIDTH);
                Rectangle rect = new Rectangle(new Point(x, y), BLOCK_WIDTH, BLOCK_HEIGHT);
                Block block = new Block(rect, colors[i - START_LINE]);
                blocks.add(block);
            }
        }
        ballsVelocities = Arrays.asList(new Velocity[] {
                Velocity.fromAngleAndSpeed(30, SPEED),
                Velocity.fromAngleAndSpeed(-30, SPEED)});
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
        return "Green 3";
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

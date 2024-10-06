// 322316506 Naama Matzliach
package levels;

import backgrounds.Background;
import backgrounds.LevelTwoBackground;

import gameSystem.Block;
import gameSystem.Velocity;
import geometryPrimitives.Point;
import geometryPrimitives.Rectangle;
import gui.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The LevelTwo class.
 * Contains the level information.
 * @author Naama Matzliach
 */
public class LevelTwo implements LevelInformation {
    private Background background;
    private List<Block> blocks;
    private List<Velocity> ballsVelocities;

    private static final int BLOCK_SIZE = 50;
    private static final int SPEED = 10;

    /**
     * Constructor.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public LevelTwo(int gameWidth, int gameHeight) {
        background = new LevelTwoBackground(Color.CYAN, gameWidth, gameHeight);
        blocks = new ArrayList<Block>();
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW };

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < 5; j++) {
                double x = (((i * 5) + j) * BLOCK_SIZE) + BLOCK_SIZE / 2;
                Rectangle rect = new Rectangle(new Point(x, gameHeight / 2.5), BLOCK_SIZE, BLOCK_SIZE / 2);
                blocks.add(new Block(rect, colors[i]));
            }
        }
        ballsVelocities = new ArrayList<Velocity>();
        for (int i = 5; i > 0; i--) {
            ballsVelocities.add(Velocity.fromAngleAndSpeed(i * 10, SPEED));
            ballsVelocities.add(Velocity.fromAngleAndSpeed(i * -10, SPEED));
        }
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
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
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

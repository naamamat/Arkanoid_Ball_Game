// 322316506 Naama Matzliach
package levels;

import backgrounds.Background;
import backgrounds.LevelFourBackground;

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
 * The LevelFour class.
 * Contains the level information.
 * @author Naama Matzliach
 */
public class LevelFour implements LevelInformation {
    private static final int BLOCK_SIZE = 50;
    private static final int SPEED = 5;

    private Background background;
    private List<Block> blocks;
    private List<Velocity> ballsVelocities;

    /**
     * The level four function.
     * @param gameWidth width.
     * @param gameHeight height.
     */
    public LevelFour(int gameWidth, int gameHeight) {
        background = new LevelFourBackground(Color.CYAN, gameWidth, gameHeight);
        blocks = new ArrayList<Block>();
        Color[] colors = {Color.green, Color.blue, Color.PINK };

        for (int k = 0; k < 7; k++) {
            double y = gameHeight / 4 + k * BLOCK_SIZE / 2;
            for (int i = 0; i < colors.length; i++) {
                for (int j = 0; j < 5; j++) {
                    double x = (((i * 5) + j) * BLOCK_SIZE) + BLOCK_SIZE / 2;
                    Rectangle rect = new Rectangle(new Point(x, y), BLOCK_SIZE, BLOCK_SIZE / 2);
                    blocks.add(new Block(rect, colors[i]));
                }
            }
        }
        ballsVelocities = Arrays.asList(new Velocity[] {
                Velocity.fromAngleAndSpeed(0, SPEED),
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
        return "Final Four";
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

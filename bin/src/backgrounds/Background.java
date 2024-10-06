// 322316506 Naama Matzliach
package backgrounds;

import biuoop.DrawSurface;
import gui.Sprite;

import java.awt.Color;

/**
 * The class Background.
 * Show the plain background with a color.
 * @author Naama Matzliach
 */
public class Background implements Sprite {
    private Color color;
    private int gameWidth;
    private int gameHeight;

    /**
     * Constructor.
     * @param color The color of background.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public Background(Color color, int gameWidth, int gameHeight) {
        this.color = color;
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
    }

    /**
     * @return The height.
     */
    public int getGameHeight() {
        return gameHeight;
    }

    /**
     * @return The width.
     */
    public int getGameWidth() {
        return gameWidth;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle(
                0,
                0,
                d.getWidth(),
                d.getHeight());
    }

    @Override
    public void timePassed() {
        return;
    }
}

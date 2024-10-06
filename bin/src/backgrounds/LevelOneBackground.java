// 322316506 Naama Matzliach
package backgrounds;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class LevelOneBackground.
 * Show the level one background with a color.
 * @author Naama Matzliach
 */
public class LevelOneBackground extends Background {

    /**
     * Constructor.
     * @param color The color of background.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public LevelOneBackground(Color color, int gameWidth, int gameHeight) {
        super(color, gameWidth, gameHeight);
    }

    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);

        d.setColor(Color.BLUE);
        d.drawCircle(getGameWidth() / 2, getGameHeight() / 4, 60);
        d.drawCircle(getGameWidth() / 2, getGameHeight() / 4, 90);
        d.drawCircle(getGameWidth() / 2, getGameHeight() / 4, 120);
        d.drawLine(getGameWidth() / 2, getGameHeight() / 4 + 30, getGameWidth() / 2, 300);
        d.drawLine(getGameWidth() / 2 + 20, getGameHeight() / 4 + 10, getGameWidth() / 2 + 140, 160);
        d.drawLine(getGameWidth() / 2 - 20, getGameHeight() / 4 + 10, getGameWidth() / 2 - 140, 160);
        d.drawLine(getGameWidth() / 2, getGameHeight() / 4 - 10, getGameWidth() / 2, 20);
    }

    @Override
    public void timePassed() {
        return;
    }
}

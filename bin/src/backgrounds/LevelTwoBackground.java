// 322316506 Naama Matzliach
package backgrounds;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class LevelTwoBackground.
 * Show the level two background with a color.
 * @author Naama Matzliach
 */
public class LevelTwoBackground extends Background {

    /**
     * Constructor.
     * @param color The color of background.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public LevelTwoBackground(Color color, int gameWidth, int gameHeight) {
        super(color, gameWidth, gameHeight);
    }

    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);

        d.setColor(Color.orange);
        d.fillCircle(getGameHeight() / 4, getGameHeight() / 4, 60);

        d.setColor(Color.YELLOW);
        d.fillCircle(getGameHeight() / 4, getGameHeight() / 4, 40);

        int numLines = 125;
        int startX = 25;
        int endX = getGameWidth() - 25;
        for (int i = 1; i <= numLines; i++) {
            if (i % 2 == 0) {
                d.setColor(Color.ORANGE);
            } else {
                d.setColor(Color.YELLOW);
            }

            d.drawLine(getGameHeight() / 4, getGameHeight() / 4, (endX - startX) / numLines * i, 250);
        }

    }

    @Override
    public void timePassed() {
        return;
    }
}

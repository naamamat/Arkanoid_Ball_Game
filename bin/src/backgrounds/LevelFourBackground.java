// 322316506 Naama Matzliach
package backgrounds;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class LevelFourBackground.
 * Show the level four background with a color.
 * @author Naama Matzliach
 */
public class LevelFourBackground extends Background {

    /**
     * Constructor.
     * @param color The color of background.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public LevelFourBackground(Color color, int gameWidth, int gameHeight) {
        super(color, gameWidth, gameHeight);
    }

    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);

        d.setColor(Color.WHITE);
        int i;
        for (i = 0; i < 10; i++) {
            d.drawLine(getGameWidth() / 8 + i * 10, getGameWidth() / 2, 80 + i * 10, getGameHeight());
        }
        d.setColor(Color.lightGray);
        d.fillCircle(getGameWidth() / 8, getGameWidth() / 2, 25);
        d.fillCircle(getGameHeight() / 5, getGameWidth() / 2 + 20, 30);
        d.fillCircle(getGameHeight() / 5 + 20, getGameWidth() / 2 - 10, 30);
        d.fillCircle(getGameHeight() / 5 + 40, getGameWidth() / 2 + 20, 20);
        d.fillCircle(getGameHeight() / 5 + 60, getGameWidth() / 2, 30);
        d.setColor(Color.WHITE);
        for (i = 0; i < 10; i++) {
            d.drawLine(getGameHeight() + i * 10, 520, getGameHeight() + i * 10, getGameHeight());
        }
        d.setColor(Color.gray);
        d.fillCircle(getGameHeight(), getGameHeight() - 100, 25);
        d.fillCircle(getGameHeight() + 20, getGameHeight() - 60, 30);
        d.fillCircle(getGameHeight() + 40, getGameHeight() - 90, 30);
        d.fillCircle(getGameHeight() + 60, getGameHeight() - 70, 20);
        d.fillCircle(getGameHeight() + 80, getGameHeight() - 80, 30);

        for (i = 0; i < 10; i++) {
            d.drawLine(getGameWidth() / 2 + i * 10, 3 * getGameHeight() / 4, getGameWidth() / 2 + i * 10,
                    getGameHeight());
        }
        d.setColor(Color.lightGray);
        d.fillCircle(getGameWidth() / 2, getGameWidth() / 2 + 50, 25);
        d.fillCircle(getGameWidth() / 2 + 20, getGameWidth() / 2 + 90, 30);
        d.fillCircle(getGameWidth() / 2 + 40, getGameWidth() / 2 + 60, 30);
        d.fillCircle(getGameWidth() / 2 + 60, getGameWidth() / 2 + 80, 20);
        d.fillCircle(getGameWidth() / 2 + 80, getGameWidth() / 2 + 70, 30);

    }

    @Override
    public void timePassed() {
        return;
    }
}

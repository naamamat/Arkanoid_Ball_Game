// 322316506 Naama Matzliach
package backgrounds;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class LevelThreeBackground.
 * Show the level three background with a color.
 * @author Naama Matzliach
 */
public class LevelThreeBackground extends Background {

    /**
     * Constructor.
     * @param color The color of background.
     * @param gameWidth The game width.
     * @param gameHeight The game height.
     */
    public LevelThreeBackground(Color color, int gameWidth, int gameHeight) {
        super(color, gameWidth, gameHeight);
    }

    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);

        d.setColor(Color.GRAY);
        d.fillRectangle(getGameWidth() / 8 + 10, getGameHeight() / 3, 10, getGameHeight() / 3);
        d.setColor(Color.ORANGE);
        d.fillCircle(getGameWidth() / 7, getGameHeight() / 3, 12);
        d.setColor(Color.RED);
        d.fillCircle(getGameWidth() / 7, getGameHeight() / 3, 8);
        d.setColor(Color.WHITE);
        d.fillCircle(getGameWidth() / 7, getGameHeight() / 3, 3);
        d.setColor(Color.BLACK);
        d.fillRectangle(getGameWidth() / 8, 2 * getGameHeight() / 3, 30, getGameHeight() / 3);
        d.setColor(Color.darkGray);
        d.fillRectangle(getGameWidth() / 12, 2 * getGameHeight() / 3 + 50, 100, getGameHeight() / 3);
        int x = getGameWidth() / 10 - 5;
        int y = 3 * getGameHeight() / 4 + 10;
        d.setColor(Color.WHITE);
        for (int rows = 0; rows < 5; rows++) {
            for (int columns = 0; columns < 5; columns++) {
                d.fillRectangle(x + columns * getGameWidth() / 45, y + rows * getGameHeight() / 19, 10, 25);
            }
        }
    }

    @Override
    public void timePassed() {
        return;
    }
}

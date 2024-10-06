// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;
import geometryPrimitives.Rectangle;
import gui.Sprite;

import java.awt.Color;

/**
 * The LevelNameIndicator class.
 * Show the level name on top of screen.
 * @author Naama Matzliach
 */
public class LevelNameIndicator implements Sprite {
    private String name;
    private Rectangle rect;

    /** Constructor.
     * Creates a level name indicator.
     * @param name The name.
     * @param rect The rectangle on the screen.
     */
    public LevelNameIndicator(String name, Rectangle rect) {
        this.name = name;
        this.rect = rect;
    }

    /** Adds the name indicator to the game.
     * @param g The game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void drawOn(DrawSurface d) {
        int x = (int) rect.getUpperLeft().getX();
        int y = (int) rect.getUpperLeft().getY();
        int width = (int) rect.getWidth();
        int height = (int) rect.getHeight();

        int textX = x + 3 * width / 4;
        int textY = (int) (height * 0.9);
        int fontSize = (int) (height * 0.9);
        String levelName = "Level Name: " + name;
        d.setColor(Color.BLACK);
        d.drawText(textX, textY, levelName, fontSize);
    }

    @Override
    public void timePassed() {
        return;
    }
}

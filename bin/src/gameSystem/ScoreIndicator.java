// 322316506 Naama Matzliach
package gameSystem;
import biuoop.DrawSurface;
import geometryPrimitives.Rectangle;
import gui.Sprite;

import java.awt.Color;

/**
 * The class ScoreIndicator.
 * Counts the score of the game.
 * @author Naama Matzliach
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private Rectangle rect;

    /** Constructor.
     * Creates a score indicator.
     * @param score The counter.
     * @param rect The rectangle on the screen.
     */
    public ScoreIndicator(Counter score, Rectangle rect) {
        this.score = score;
        this.rect = rect;
    }

    /** Adds the score indicator to the game.
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

        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, width, height);
        d.setColor(Color.BLACK);
        d.drawRectangle(0, 0, width, height);

        int textX = x + width / 2;
        int textY = (int) (height * 0.9);
        int fontSize = (int) (height * 0.9);
        String currentScore = "Score: " + score.getValue();
        d.setColor(Color.BLACK);
        d.drawText(textX, textY, currentScore, fontSize);
    }

    @Override
    public void timePassed() {
        return;
    }
}

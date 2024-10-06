// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The EndScreen class.
 * Show the score and game over or win on the screen.
 * @author Naama Matzliach
 */
public class EndScreen implements Animation {
    private int score;
    private boolean isWin;

    /**
     * Constructor.
     * @param score The final score.
     * @param isWin If win or lose.
     */
    public EndScreen(int score, boolean isWin) {
        this.score = score;
        this.isWin = isWin;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        String message;
        if (isWin) {
            message = "You Win!";
        } else {
            message = "Game Over.";
        }
        message += " Your score is: " + score;
        d.drawText(
                100,
                d.getHeight() / 2,
                message,
                32);

        d.drawText(
                100,
                3 * d.getHeight() / 4,
                "Press space to exit",
                32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
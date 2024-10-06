// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The PauseScreen class.
 * Pause the game and shows what to press to continue.
 * @author Naama Matzliach
 */
public class PauseScreen implements Animation {

    /**
     * Constructor.
     * the pause screen.
     */
    public PauseScreen() {
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(
                100,
                d.getHeight() / 2,
                "paused -- press space to continue",
                32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}
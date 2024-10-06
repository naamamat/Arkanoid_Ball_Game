// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;

/**
 * The interface Animation.
 * Make a screen.
 * @author Naama Matzliach
 */
public interface Animation {
    /**
     * One frame has passed.
     * @param d The drawsurface from gui.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Returns true when should stop show the screen.
     * @return when need to stop.
     */
    boolean shouldStop();

}

// 322316506 Naama Matzliach
package gui;
import biuoop.DrawSurface;


/**
 * The Sprite interface.
 * Make sprite for the game.
 * @author Naama Matzliach
 */
public interface Sprite {

    /** The function draw on.
     * Draw the sprite to the screen
     * @param d the draw surface.
     */
    void drawOn(DrawSurface d);

    /** The function time passed.
     * Notify the sprite that time has passed
     */
    void timePassed();
}
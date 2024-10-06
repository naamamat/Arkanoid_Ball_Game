// 322316506 Naama Matzliach
package gameSystem;
import biuoop.DrawSurface;
import gui.Sprite;

import java.util.ArrayList;
import java.util.List;


/**
 * The class SpriteCollection.
 * make sprite collection for game.
 * @author Naama Matzliach
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /** Constructor.
     * Creates new sprite collection.
     * @param sprites list.
     */
    public SpriteCollection(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    /** Constructor.
     * Creates new sprite collection by empty list sprite.
     */
    public SpriteCollection() {
        sprites = new ArrayList<Sprite>();
    }

    /** The add sprite function.
     * Add sprite for thr collection.
     * @param s new sprite.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /** The remove sprite function.
     * Removes sprite for thr collection.
     * @param s new sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /** The notifyAllTimePassed function.
     * Call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> tempSprites = new ArrayList<Sprite>(sprites);
        for (Sprite s: tempSprites) {
            s.timePassed();
        }
    }

    /** The drawAllOn function.
     * Call drawOn(d) on all sprites.
     * @param d drawsurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s: sprites) {
            s.drawOn(d);
        }
    }
}
// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;
import geometryPrimitives.Line;
import geometryPrimitives.LineBorder;
import geometryPrimitives.Point;
import geometryPrimitives.Rectangle;
import gui.Collidable;
import gui.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * The class Block.
 * Make a block in space.
 * @author Naama Matzliach
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners;
    private static final Color DEFAULT_COLOR = Color.GRAY;

    /** Constructor.
     * Creates new block.
     * @param rect The rectangle.
     * @param color The color.
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }


    /** Constructor.
     * Creates new block by default color.
     * @param rect The rectangle.
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        this.color = DEFAULT_COLOR;
        this.hitListeners = new ArrayList<HitListener>();
    }

    @Override
    /** The function get collision rectangle.
     * Get the collision.
     * @param rect The rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);

        Line[] rectLines = rect.getRectangleLines();

        int lineIndex = -1;

        for (int i = 0; i < rectLines.length; i++) {
            if (rectLines[i].pointOnLine(collisionPoint)) {
                lineIndex = i;
            }
        }

        // The point is not touching the block
        if (lineIndex == -1) {
            return currentVelocity;
        }

        LineBorder lineBorder = LineBorder.getBorderFromIndex(lineIndex);

        // Adding for safety
        if (lineBorder == null) {
            return currentVelocity;
        }

        Velocity afterVelocity = new Velocity(currentVelocity);
        double dx = afterVelocity.getDx();
        double dy = afterVelocity.getDy();

        switch (lineBorder) {
            case UP:
                afterVelocity.setDy(dy * -1);
                break;
            case DOWN:
                afterVelocity.setDy(dy * -1);
                break;
            case LEFT:
                afterVelocity.setDx(dx * -1);
                break;
            case RIGHT:
                afterVelocity.setDx(dx * -1);
                break;
            default:
                break;
        }

        return afterVelocity;
    }

    @Override
    /** The function draw on.
     * Draw on the game.
     * @param d the draw surface.
     */
    public void drawOn(DrawSurface d) {
        int x = (int) rect.getUpperLeft().getX();
        int y = (int) rect.getUpperLeft().getY();
        int width = (int) rect.getWidth();
        int height = (int) rect.getHeight();

        d.setColor(color);
        d.fillRectangle(x, y, width, height);
        d.setColor(Color.BLACK);
        d.drawRectangle(x, y, width, height);

    }

    @Override
    /** The function time passed.
     * Response on time.
     */
    public void timePassed() {
        return;
    }

    /** The function add to game
     * response add this object to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /** The function remove object from game.
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}

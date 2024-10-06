// 322316506 Naama Matzliach
package gameSystem;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometryPrimitives.Line;
import geometryPrimitives.Point;
import geometryPrimitives.Rectangle;
import gui.Collidable;
import gui.Sprite;

import java.awt.Color;

/**
 * The class gameSystem.Paddle.
 * Represents paddle on space.
 * @author Naama Matzliach
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle rect;
    private Color color;
    private int borderLeftX;
    private int borderRightX;
    private int speed;

    private static final Color DEFAULT_COLOR = Color.GRAY;

    /** Constructor.
     * Creates new paddle.
     * @param rect rectangle
     * @param color paddle.
     * @param keyboard for move the paddle.
     * @param borderLeftX movement.
     * @param borderRightX movement.
     * @param speed movement.
     */
    public Paddle(Rectangle rect, Color color, KeyboardSensor keyboard, int borderLeftX,  int borderRightX, int speed) {
        this.rect = rect;
        this.color = color;
        this.keyboard = keyboard;
        this.borderLeftX = borderLeftX;
        this.borderRightX = borderRightX;
        this.speed = speed;
    }

    /** Constructor.
     * Creates new paddle by default color.
     * @param rect rectangle
     * @param keyboard for move the paddle.
     * @param borderLeftX movement.
     * @param borderRightX movement.
     * @param speed movement.
     */
    public Paddle(Rectangle rect, KeyboardSensor keyboard, int borderLeftX,  int borderRightX, int speed) {
        this.rect = rect;
        this.color = DEFAULT_COLOR;
        this.keyboard = keyboard;
        this.borderLeftX = borderLeftX;
        this.borderRightX = borderRightX;
        this.speed = speed;
    }

    /** The move left function.
     * Creates moves paddle left.
     */
    public void moveLeft() {
        double newX = rect.getUpperLeft().getX() - speed;
        if (newX < borderLeftX) {
            newX = borderLeftX;
        }
        rect.setUpperLeft(new Point(newX, rect.getUpperLeft().getY()));
        return;
    }

    /** The move right function.
     * Creates moves paddle right.
     */
    public void moveRight() {
        double newX = rect.getUpperLeft().getX() + speed;
        if (newX > borderRightX - rect.getWidth()) {
            newX = borderRightX - rect.getWidth();
        }
        rect.setUpperLeft(new Point(newX, rect.getUpperLeft().getY()));
        return;
    }

    /** The function time passed.
     * Response on time.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
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

    /** The function getCollisionRectangle.
     * Gets Collision for rectangle.
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
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

        double hitX = collisionPoint.getX() - rect.getUpperLeft().getX(); // Where it hit on the paddle
        double fractionHit = hitX / rect.getWidth();

        Velocity afterVelocity = new Velocity(currentVelocity);
        if (fractionHit <= 0.2) {
            afterVelocity.updateByAngle(300);
        } else if (fractionHit <= 0.4) {
            afterVelocity.updateByAngle(330);
        } else if (fractionHit <= 0.6) {
            double dy = afterVelocity.getDy();

            afterVelocity.setDy(dy * -1);
        } else if (fractionHit <= 0.8) {
            afterVelocity.updateByAngle(30);
        } else {
            afterVelocity.updateByAngle(60);
        }

        return afterVelocity;
    }

    //

    /** The function addToGame.
     * Add this paddle to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
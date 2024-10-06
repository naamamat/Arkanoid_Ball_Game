// 322316506 Naama Matzliach
package gameSystem;

import biuoop.DrawSurface;
import geometryPrimitives.Line;
import geometryPrimitives.Point;
import gui.Sprite;

import java.awt.Color;

/**
 * The class Ball.
 * Make a ball in space.
 * @author Naama Matzliach
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /** Constructor.
     * Creates new ball.
     * @param center The x and y of the point
     * @param r The size of the ball
     * @param color The color
     * @param gameEnvironment The game environment containing the collidables
     */
    public Ball(Point center, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(center);
        radius = r;
        this.color = color;
        velocity = new Velocity();
        this.gameEnvironment = new GameEnvironment(gameEnvironment);
    }

    /** Constructor.
     * Creates new ball.
     * @param x The x's of the center
     * @param y The y's of the center
     * @param r The size of the ball
     * @param gameEnvironment The game environment containing the collidables
     * @param color The color
     */
    public Ball(double x, double y, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        radius = r;
        this.color = color;
        velocity = new Velocity();
        this.gameEnvironment = new GameEnvironment(gameEnvironment);
    }

    /** Get the x of the center ball.
     * @return x of the center.
     */
    public int getX() {
        return (int) center.getX();
    }

    /** Get the y of the center ball.
     * @return y of the center.
     */
    public int getY() {
        return (int) center.getY();
    }

    /** Get size of radius.
     * @return radius.
     */
    public int getSize() {
        return radius;
    }

    /** Get color of the ball.
     * @return color.
     */
    public Color getColor() {
        return color;
    }

    @Override
    /** Draw on by DrawSurface.
     * @param surface drawsurface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle(getX(), getY(), radius);
    }

    @Override
    /** The function time passed.
     * responsible time and move a step.
     */
    public void timePassed() {
        moveOneStep();
    }

    /** The function add to game
     * response add this object to the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /** The function remove object from game.
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /** Set setVelocity of the ball by velocity.
     * @param v velocity.
     */
    public void setVelocity(Velocity v) {
        velocity = new Velocity(v);
    }
    /** Set setVelocity of the ball by parameters.
     * @param dx of step.
     * @param dy of step.
     */
    public void setVelocity(double dx, double dy) {
        velocity = new Velocity(dx, dy);
    }

    /** Get gameSystem.Velocity.
     * @return velocity.
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /** The function moveOneStep.
     * Set your step velocity.
     */
    public void moveOneStep() {
        Point endTrajectory = getVelocity().applyToPoint(center);
        Line trajectory = new Line(center, endTrajectory);

        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);

        // No collision
        if (collisionInfo == null) {
            center = endTrajectory;
            return;
        }

        Point collisionPoint = collisionInfo.collisionPoint();

        double almostDif = 1 - 0.0001;
        double dx = collisionPoint.getX() - center.getX();
        double dy = collisionPoint.getY() - center.getY();
        double almostTouchingX = center.getX() + dx * almostDif;
        double almostTouchingY = center.getY() + dy * almostDif;
        center = new Point(almostTouchingX, almostTouchingY);

        // Update the new velocity after hit
        setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), getVelocity()));
    }
}
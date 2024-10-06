// 322316506 Naama Matzliach
package gameSystem;
import geometryPrimitives.Point;

/**
 * The class Velocity.
 * Represents Velocity specifies the change in position
 * on the `x` and the `y` axes.
 * @author Naama Matzliach
 */
public class Velocity {
    private double dx;
    private double dy;

    /** Constructor.
     * Creates new velocity.
     * @param dx of delta step.
     * @param dy of delta step.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /** Constructor.
     * Creates new velocity with zero velocity.
     */
    public Velocity() {
        dx = 0;
        dy = 0;
    }

    /** Copy constructor.
     * Creates new velocity.
     * @param v of other velocity.
     */
    public Velocity(Velocity v) {
        this.dx = v.getDx();
        this.dy = v.getDy();
    }

    /** Make your velocity by angle and speed.
     * @param angle of step.
     * @param speed for a step.
     * @return new velocity of delta step.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.cos(Math.toRadians(calculateRightAngle(angle))) * speed;
        double dy = Math.sin(Math.toRadians(calculateRightAngle(angle))) * speed;
        return new Velocity(dx, dy);
    }

    /** Calculate the right angle, because sin and cos give right values
     * for regular function x and y.
     * @param angle Old angle
     * @return The right angle
     */
    private static double calculateRightAngle(double angle) {
        angle -= 90;
        return angle;
    }

    /** Update your velocity by angle, needs to calculate the speed first.
     * @param angle New angle
     */
    public void updateByAngle(double angle) {
        double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        dx = Math.cos(Math.toRadians(calculateRightAngle(angle))) * speed;
        dy = Math.sin(Math.toRadians(calculateRightAngle(angle))) * speed;
        return;
    }

    /** Get the x of the velocity.
     * @return dx of delta step.
     */
    public double getDx() {
        return dx;
    }

    /** Get the y of the velocity.
     * @return dy of delta step.
     */
    public double getDy() {
        return dy;
    }

    /** Set the x of the velocity.
     * @param dx of delta step.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /** Set the y of the velocity.
     * @param dy of delta step.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }


    /**Take a point with position and return a new point with position.
     * @param p The other point(x,y).
     * @return x a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + dx;
        double newY = p.getY() + dy;
        return new Point(newX, newY);
    }
}
// 322316506 Naama Matzliach
package gui;
import gameSystem.Ball;
import gameSystem.Velocity;
import geometryPrimitives.Point;
import geometryPrimitives.Rectangle;

/**
 * The Collidable interface.
 * Make collidable in space.
 * @author Naama Matzliach
 */
public interface Collidable {

    /**
     * The getCollisionRectangle function.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * The hit function.
     *
     * @param hitter gameSystem.Ball
     * @param collisionPoint  point,
     * @param currentVelocity velocity.
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * @return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

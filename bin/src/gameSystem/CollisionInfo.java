// 322316506 Naama Matzliach
package gameSystem;

import geometryPrimitives.Point;
import gui.Collidable;

/**
 * The class CollisionInfo.
 * Make collision information.
 * @author Naama Matzliach
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /** Constructor.
     * Creates new collision info.
     * @param collisionPoint the point.
     * @param collisionObject the object.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = new Point(collisionPoint);
        this.collisionObject = collisionObject;
    }

    /** The collisionPoint function.
     * The point at which the collision occurs.
     * @return point collision.
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /** The setCollisionPoint function.
     * To set collision point.
     * @param collisionPoint the point.
     */
    public void setCollisionPoint(Point collisionPoint) {
        this.collisionPoint = new Point(collisionPoint);
    }

    /** The setCollisionObject function.
     * To set collision object.
     * @param collisionObject the collidable.
     */
    public void setCollisionObject(Collidable collisionObject) {
        this.collisionObject = collisionObject;
    }

    /** The collisionObject function.
     * The collidable object involved in the collision.
     * @return collision object.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}
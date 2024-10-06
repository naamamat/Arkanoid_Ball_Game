// 322316506 Naama Matzliach
package gameSystem;
import geometryPrimitives.Line;
import geometryPrimitives.Point;
import gui.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * The class GameEnvironment.
 * Make a game enviroment.
 * @author Naama Matzliach
 */
public class GameEnvironment {

    private List<Collidable> collidables;

    /** Constructor.
     * Creates new game environment.
     * @param collidables list.
     */
    public GameEnvironment(List<Collidable> collidables) {
        this.collidables = collidables;
    }


    /** Constructor.
     * Creates new game environment.
     * by default empty collidable list
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /** Copy constructor.
     * Creates new game environment.
     * @param gameEnvironment for copy.
     */
    public GameEnvironment(GameEnvironment gameEnvironment) {
        collidables = gameEnvironment.getCollidables();
    }

    /** The getCollidables function .
     * Get collidables.
     * @return collidable list.
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }


    /** The addCollidable function .
     * Add the given collidable to the environment.
     * @param c collidable.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }


    /** The removeCollidable function .
     * Remove the given collidable from the environment.
     * @param c collidable.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /** The gameSystem.CollisionInfo function .
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory line.
     * @return collision information.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo collisionInfo = null;

        List<Collidable> tempCollidables = new ArrayList<Collidable>(collidables);
        for (Collidable collidable: tempCollidables) {
            Point intersectPoint = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());

            // The line will not collide with this object
            if (intersectPoint == null) {
                continue;
            }

            if (collisionInfo == null) {
                collisionInfo = new CollisionInfo(intersectPoint, collidable);
            } else {
                Point closestPoint = collisionInfo.collisionPoint();
                if (intersectPoint.distance(trajectory.start()) < closestPoint.distance(trajectory.start())) {
                    collisionInfo.setCollisionPoint(intersectPoint);
                    collisionInfo.setCollisionObject(collidable);
                }
            }
        }

        return collisionInfo;
    }

}
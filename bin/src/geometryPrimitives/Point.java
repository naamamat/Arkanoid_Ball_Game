// 322316506 Naama Matzliach

package geometryPrimitives;

/**
 * The class Point.
 * Represents point in the space.
 * @author Naama Matzliach
 */
public class Point {

    private double x;
    private double y;

    /** Constructor.
     * Creates new point.
     * @param x The x's of the point
     * @param y The y's of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Copy Constructor.
     * Creates new point by another point.
     * @param other The existing point
     */
    public Point(Point other) {
        x = other.getX();
        y = other.getY();
    }

    /** Calculates the distance to another point.
     * @param other The other point
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        double xSquare = (other.getX() - x) * (other.getX() - x);
        double ySquare = (other.getY() - y) * (other.getY() - y);

        return Math.sqrt(xSquare + ySquare);
    }

    /** Checks if both points are equal.
     * @param other The other point
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (x == other.getX() && y == other.getY()) {
            return true;
        }
        return false;
    }

    /** Get the x of the point.
     * @return x
     */
    public double getX() {
        return x;
    }

    /** Get the y of the point.
     * @return y
     */
    public double getY() {
        return y;
    }
}
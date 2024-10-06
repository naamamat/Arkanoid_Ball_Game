// 322316506 Naama Matzliach

package geometryPrimitives;

import java.util.List;

/**
 * The class Line.
 * Represents line, consists of two points in the space.
 * @author Naama Matzliach
 */
public class Line {

    private Point start;
    private Point end;

    /** Constructor.
     * Creates new line.
     * @param start The start point
     * @param end The end point
     */
    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    /** Constructor.
     * Creates new line.
     * @param x1 The x of the start point
     * @param x2 The x of the end point
     * @param y1 The y of the start point
     * @param y2 The y of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }

    /** Get the length of the line, by calculating the distance of the points.
     * @return The length of the line
     */
    public double length() {
        return start.distance(end);
    }

    /** Calculate the middle point.
     * @return The middle point of the line
     */
    public Point middle() {
        double midX = (start.getX() + end.getX()) / 2;
        double midY = (start.getY() + end.getY()) / 2;
        return new Point(midX, midY);
    }

    /** Get the start point.
     * @return The start point of the line
     */
    public Point start() {
        return start;
    }

    /** Get the end point.
     * @return The end point of the line
     */
    public Point end() {
        return end;
    }

    /** Get the slope of the line.
     * @return The slope
     */
    public double slope() {
        double yDif = start.getY() - end.getY();
        double xDif = start.getX() - end.getX();

        if (xDif == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return yDif / xDif;
    }

    /** Get the intercept of the line.
     * @param m slope
     * @return The intercept
     */
    public double intercept(double m) {
        return start.getY() - (start.getX() * m);
    }

    /** Get the minimum x of the line.
     * @return The minimum x of the line
     */
    public double minX() {
        return Math.min(start.getX(), end.getX());
    }

    /** Get the maximum x of the line.
     * @return The maximum x of the line
     */
    public double maxX() {
        return Math.max(start.getX(), end.getX());
    }

    /** Get the minimum y of the line.
     * @return The minimum y of the line
     */
    public double minY() {
        return Math.min(start.getY(), end.getY());
    }

    /** Get the maximum y of the line.
     * @return The maximum y of the line
     */
    public double maxY() {
        return Math.max(start.getY(), end.getY());
    }

    /** Check if the lines are intersecting.
     * @param other the line to check with
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /** Check if the lines are intersecting and return the point if it is.
     * @param other the line to check with
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double m1 = slope();
        double m2 = other.slope();

        if (m1 == m2) {
            return null;
        }

        double xIntersect;
        double yIntersect;

        if (m1 == Double.POSITIVE_INFINITY) {
            xIntersect = start.getX();
            double b2 =  other.intercept(m2);

            yIntersect = m2 * xIntersect + b2;
        } else if (m2 == Double.POSITIVE_INFINITY) {
            xIntersect = other.start.getX();
            double b1 =  intercept(m1);

            yIntersect = m1 * xIntersect + b1;
        } else {
            double b1 =  intercept(m1);
            double b2 =  other.intercept(m2);

            xIntersect = (b2 - b1) / (m1 - m2);
            yIntersect = m1 * xIntersect + b1;
        }

        Point intersectPoint = new Point(xIntersect, yIntersect);

        if (!pointOnLines(intersectPoint, other)) {
            return null;
        }

        return intersectPoint;
    }

    /** Check if the point is on both lines.
     * @param point geometryPrimitives.Point ot check with
     * @param other The line to check with
     * @return True if on lines or false otherwise
     */
    public boolean pointOnLines(Point point, Line other) {
        double x = point.getX();
        double y = point.getY();

        // geometryPrimitives.Line 1
        if (x < minX() || x > maxX()) {
            return false;
        }

        if (y < minY() || y > maxY()) {
            return false;
        }

        // geometryPrimitives.Line 2
        if (x < other.minX() || x > other.maxX()) {
            return false;
        }

        if (y < other.minY() || y > other.maxY()) {
            return false;
        }

        return true;
    }

    /** Check if the point is on the line.
     * @param point geometryPrimitives.Point ot check with
     * @return True if on line or false otherwise
     */
    public boolean pointOnLine(Point point) {
        double x = point.getX();
        double y = point.getY();

        if (x < minX() || x > maxX()) {
            return false;
        }

        if (y < minY() || y > maxY()) {
            return false;
        }

        return true;
    }

    /** Check if the lines are equal.
     * @param other the line to check with
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (minX() != other.minX() || minY() != other.minY()) {
            return false;
        }
        if (maxX() != other.maxX() || maxY() != other.maxY()) {
            return false;
        }
        return true;
    }

    /** If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * @param rect The rectangle
     * @return the closest intersection point to the start of the line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> pointsList = rect.intersectionPoints(this);

        if (pointsList.isEmpty()) {
            return null;
        }

        Point closestPoint = pointsList.get(0);

        for (Point intersectPoint: pointsList) {
            if (intersectPoint.distance(start) < closestPoint.distance(start)) {
                closestPoint = intersectPoint;
            }
        }

        return closestPoint;
    }

    /** Calculate the equation of the line and check the corresponding
     * Y for the specified X.
     * @param x The x to check
     * @return The corresponding Y
     */
    public double getLineYByX(double x) {
        double m = slope();
        double b = intercept(m);

        // y = m*x + b
        return m * x + b;
    }
}

// 322316506 Naama Matzliach

package geometryPrimitives;

import java.util.List;
import java.util.ArrayList;

/**
 * The class Rectangle.
 * @author Naama Matzliach
 */
public class Rectangle {
    private Point upperLeft;
    private double width, height;

    /** Constructor.
     * Create a new rectangle with location and width/height.
     * @param upperLeft point.
     * @param width info.
     * @param height info.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /** The getRectangleLines function.
     * Gets rectangle lines.
     * @return list of lines.
     */
    public Line[] getRectangleLines() {
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);

        Line[] rectangleLines = new Line[LineBorder.values().length];
        rectangleLines[LineBorder.UP.getIndex()] = new Line(upperLeft, upperRight); // Upper line
        rectangleLines[LineBorder.LEFT.getIndex()] = new Line(upperLeft, lowerLeft); // Left line
        rectangleLines[LineBorder.RIGHT.getIndex()] = new Line(upperRight, lowerRight); // Right line
        rectangleLines[LineBorder.DOWN.getIndex()] = new Line(lowerLeft, lowerRight); // Lower line

        return rectangleLines;
    }



    /** The intersectionPoints function.
     * Return a (possibly empty) List of intersection points.
     * with the specified line.
     * @param line for check.
     * @return list of intersection points.
     */
    public List<Point> intersectionPoints(Line line) {
        Line[] rectangleLines = getRectangleLines();

        List<Point> pointsList = new ArrayList<Point>();
        for (int i = 0; i < rectangleLines.length; i++) {

            Point intersectPoint = rectangleLines[i].intersectionWith(line);
            if (intersectPoint != null) {
                pointsList.add(intersectPoint);
            }
        }

        return pointsList;
    }

    /** The getWidth function.
     * @return the width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /** The getHeight function.
     * @return turn the height of the rectangle
     */
    public double getHeight() {
        return height;
    }



    /** The getUpperLeft function.
     *@return rns the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /** The setUpperLeft function.
     * @param upperLeft and set the point of the rectangle.
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }
}
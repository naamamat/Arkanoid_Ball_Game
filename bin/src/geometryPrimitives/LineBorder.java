// 322316506 Naama Matzliach
package geometryPrimitives;
/**
 * The Enum LineBorder.
 * Represents line border by index.
 * @author Naama Matzliach
 */
public enum LineBorder {
    UP(0), DOWN(1), LEFT(2), RIGHT(3);

    private final int index;

    /** Creates line border by index.
     * @param index by user.
     */
    LineBorder(final int index) {
        this.index = index;
    }

    /** Get the border by index.
     * @param index by user.
     * @return border from index.
     */
    public static LineBorder getBorderFromIndex(int index) {
        if (index == UP.getIndex()) {
            return UP;
        } else if (index == DOWN.getIndex()) {
            return DOWN;
        } else if (index == LEFT.getIndex()) {
            return LEFT;
        } else if (index == RIGHT.getIndex()) {
            return RIGHT;
        }
        return null;
    }

    /** Get index function.
     * @return index for user.
     */
    public int getIndex() {
        return index;
    }
}

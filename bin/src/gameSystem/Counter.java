// 322316506 Naama Matzliach
package gameSystem;
/**
 * The class Counter.
 * Allows to have an integer counter.
 * @author Naama Matzliach
 */
public class Counter {
    private int counter;

    /** The constructor
     * Create an object counter.
     */
    public Counter() {
        counter = 0;
    }

    /** The constructor
     * Create an object counter from initial counter.
     * @param initialCounter The initial value.
     */
    public Counter(int initialCounter) {
        counter = initialCounter;
    }

    /** The increase function.
     * Add number to current count.
     * @param number The number to increase.
     */
    public void increase(int number) {
        counter += number;
    }

    /** The decrease function.
     * Subtract number from current count.
     * @param number The number to decrease
     */
    public void decrease(int number) {
        counter -= number;
    }

    /** The getValue function.
     * Get current count.
     * @return The current value.
     */
    public int getValue() {
        return counter;
    }
}
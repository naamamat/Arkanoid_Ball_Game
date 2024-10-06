// 322316506 Naama Matzliach
package gameSystem;
/**
 * The class ScoreTrackingListener.
 * The score track listener that adds the score.
 * @author Naama Matzliach
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    private static final int POINTS_PER_BLOCK = 5;

    /** Constructor
     * Creates new score tracking listener.
     * @param scoreCounter The counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       currentScore.increase(POINTS_PER_BLOCK);
    }
}
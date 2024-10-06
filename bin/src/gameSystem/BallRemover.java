// 322316506 Naama Matzliach
package gameSystem;

/**
 * The class BallRemover.
 * Remove ball from game
 * @author Naama Matzliach
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /** The constructor
     * Create ball remover.
     * @param game the game.
     * @param remainingBalls the number of balls remaining.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /** The lower block border should keep the listener and remove the ball from the game.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);
    }
}

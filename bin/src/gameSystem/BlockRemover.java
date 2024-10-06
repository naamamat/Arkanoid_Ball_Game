// 322316506 Naama Matzliach
package gameSystem;

/**
 * The class BlockRemover.
 * a BlockRemover is in charge of removing blocks from the game,
 * as well as keeping count of the number of blocks that remain.
 * @author Naama Matzliach
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /** The constructor
     * Create block remover.
     * @param game the game.
     * @param remainingBlocks the number of blocks remaining.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /** Blocks that are hit should be removed
    * from the game and remove this listener from the block
    * that is being removed from the game.
    */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);
    }
}
// 322316506 Naama Matzliach
package gameSystem;


/**
 * The interface HitListener.
 * Listen to hit blocks.
 * @author Naama Matzliach
 */
public interface HitListener {
    /** This method is called whenever the beingHit object is hit.
     * The hitter parameter is the gameSystem.Ball that's doing the hitting.
     * @param beingHit The block being hit.
     * @param hitter The hitting block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
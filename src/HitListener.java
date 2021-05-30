//205588940

/**
 * This interfrace is for the hitLisners,that upon hit they will perform certain actions.
 */

public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit the block is being hit.
     * @param hitter the ball is doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
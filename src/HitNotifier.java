//205588940

/**
 * This interface is for listeners that notify about certain thing.
 */
public interface HitNotifier {
    // Add hl as a listener to hit events.

    /**
     * This method adds HitLisner to the game.
     * @param hl The hitListner.
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.

    /**
     * This method removes HitListner from the game.
     * @param hl the hitListner.
     */
    void removeHitListener(HitListener hl);
}
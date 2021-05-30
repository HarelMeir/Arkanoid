//205588940
/**
 * BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks remains.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Constructor.
     * @param game a game.
     * @param removedBlocks a counter.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * This method is a getter of remainBloaks.
     * @return this remainingBlocks.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //removes the bloak from the game upon hit.
        beingHit.removeFromGame(this.game);
        //decrese the remaining bloaks number by 1.
        this.remainingBlocks.decrease(1);
        //remove its listner.
        beingHit.removeHitListener(this);
    }
}
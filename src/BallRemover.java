//205588940
/**
 * This is a Hitlistner, in charge of removing the balls. upon hit.
 */
public class BallRemover implements HitListener {
    //members
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructor.
     * @param game a game.
     */
    public BallRemover(GameLevel game) {
        this.game = game;
        this.remainingBalls = new Counter(3);
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        game.getRemainingBalls().decrease(1);
    }
}

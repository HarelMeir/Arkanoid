//205588940

/**
 * This class is a Hitlistner for counting the score.
 */

public class ScoreTrackingListener implements HitListener {
    //member
    private Counter currentScore;

    /**
     * constrctor.
     * @param scoreCounter the score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //upon a block being hited adds 5 points.
       currentScore.increase(5);
       //removes the listner from the list.
       beingHit.removeHitListener(this);
    }
}
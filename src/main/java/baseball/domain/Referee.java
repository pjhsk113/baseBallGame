package baseball.domain;

import baseball.domain.result.BallCount;
import baseball.domain.result.JudgmentMachine;

public class Referee {
    private final BallCount ballCount;

    private Referee(BallCount ballCount) {
        this.ballCount = ballCount;
    }

    public static Referee of() {
        return new Referee(new BallCount(0, 0));
    }

    public static Referee getBallCountResult(GameHost gameHostPickNumber, Player playerPickNumber) {
        return JudgmentMachine.judgmentResult(gameHostPickNumber, playerPickNumber);
    }

    public boolean isAllStrike() {
        if (this.ballCount.getStrike() == 3) {
            return true;
        }
        return false;
    }

    public void strike() {
        ballCount.plusStrike();
    }

    public void ball() {
        ballCount.plusBall();
    }

    public int getHitStrike() {
        return ballCount.getStrike();
    }

    public int getHitBall() {
        return ballCount.getBall();
    }
}

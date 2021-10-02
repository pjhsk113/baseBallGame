package baseball.domain;

import baseball.domain.contant.GameRules;
import baseball.domain.result.BallCount;
import baseball.domain.result.JudgmentMachine;

public class Referee {
    private final BallCount ballCount;

    private Referee(BallCount ballCount) {
        this.ballCount = ballCount;
    }

    public static Referee of(GameHost gameHostPickNumber, Player playerPickNumber) {
        BallCount ballCount = JudgmentMachine.judgmentResult(gameHostPickNumber, playerPickNumber);
        return new Referee(ballCount);
    }

    public boolean isAllStrike() {
        if (this.ballCount.getStrike() == GameRules.SIZE.value()) {
            return true;
        }
        return false;
    }

    public int getHitStrike() {
        return ballCount.getStrike();
    }

    public int getHitBall() {
        return ballCount.getBall();
    }
}

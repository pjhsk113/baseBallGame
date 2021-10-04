package baseball.domain.result;

import baseball.contant.GameRules;
import baseball.domain.BaseballNumber;
import baseball.domain.GameHost;
import baseball.domain.Player;

public class JudgmentMachine {
    private JudgmentMachine() {
    }

    public static BallCount judgmentResult(GameHost targetNumber, Player playerPickNumber) {
        return getBallCount(targetNumber.getTargetNumbers(), playerPickNumber.getBaseballNumbers());
    }

    private static BallCount getBallCount(BaseballNumber targetNumber, BaseballNumber playerPickNumber) {
        BallCount ballCount = new BallCount(0, 0);

        for (int i = 0; i < GameRules.SIZE.value(); i++) {
            ballCount = judgment(ballCount, targetNumber, playerPickNumber, i);
        }

        return ballCount;
    }

    private static BallCount judgment(BallCount ballCount, BaseballNumber targetNumbers, BaseballNumber playerPickNumbers, int index) {
        int targetNumber = targetNumbers.valueOf(index);
        int pickNumber = playerPickNumbers.valueOf(index);

        if (isStrike(targetNumber, pickNumber)) {
            ballCount.plusStrike();
        }

        if (isBall(targetNumbers, targetNumber, pickNumber)) {
            ballCount.plusBall();
        }
        return ballCount;
    }

    private static boolean isStrike(int targetNumber, int pickNumber) {
        if (targetNumber == pickNumber) {
            return true;
        }
        return false;
    }

    private static boolean isBall(BaseballNumber target, int targetNumber, int pickNumber) {
        if (!isStrike(targetNumber, pickNumber) && target.hasNumber(pickNumber)) {
            return true;
        }
        return false;
    }
}

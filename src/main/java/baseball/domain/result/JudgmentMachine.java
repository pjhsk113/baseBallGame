package baseball.domain.result;

import baseball.domain.BaseballNumber;
import baseball.domain.GameHost;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.domain.contant.GameRules;

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
        Integer targetNumber = convert(targetNumbers)[index];
        Integer pickNumber = convert(playerPickNumbers)[index];

        if (isStrike(targetNumber, pickNumber)) {
            ballCount.plusStrike();
        }

        if (isBall(targetNumbers, targetNumber, pickNumber)) {
            ballCount.plusBall();
        }
        return ballCount;
    }

    private static boolean isStrike(Integer targetNumber, Integer number) {
        if (targetNumber.equals(number)) {
            return true;
        }
        return false;
    }

    private static boolean isBall(BaseballNumber target, Integer targetNumber, Integer number) {
        if (!isStrike(targetNumber, number) && target.getBaseBallNumbers().contains(number)) {
            return true;
        }
        return false;
    }

    private static Integer[] convert(BaseballNumber numbers) {
        Integer[] numberToArray = new Integer[3];
        numbers.getBaseBallNumbers().toArray(numberToArray);
        return numberToArray;
    }
}

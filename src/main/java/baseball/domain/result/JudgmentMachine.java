package baseball.domain.result;

import baseball.domain.BaseballNumber;
import baseball.domain.GameHost;
import baseball.domain.Player;
import baseball.domain.Referee;

public class JudgmentMachine {
    private JudgmentMachine() {
    }

    public static Referee judgmentResult(GameHost targetNumber, Player playerPickNumber) {
        return getBallCount(targetNumber.getTargetNumbers(), playerPickNumber.getBaseballNumbers());
    }

    private static Referee getBallCount(BaseballNumber targetNumber, BaseballNumber playerPickNumber) {
        Referee referee = Referee.of();

        for (int i = 0; i < 3; i++) {
            referee = ballCount(referee, targetNumber, playerPickNumber, i);
        }

        return referee;
    }

    private static Referee ballCount(Referee referee, BaseballNumber targetNumbers, BaseballNumber playerPickNumbers, int index) {
        Integer targetNumber = convert(targetNumbers)[index];
        Integer pickNumber = convert(playerPickNumbers)[index];

        if (isStrike(targetNumber, pickNumber)) {
            referee.strike();
        }

        if (isBall(targetNumbers, targetNumber, pickNumber)) {
            referee.ball();
        }
        return referee;
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

package baseball.view;

import baseball.domain.Referee;

public class OutputView {
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String BALL_FORMAT = "%d볼";
    private static final String BALL_COUNT_FORMAT = "%d스트라이크 %d볼";
    private static final String NOTHING = "낫싱";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";


    private OutputView() {
    }

    public static void printResult(Referee referee) {
        System.out.println(printFormatString(referee));
    }

    private static String printFormatString(Referee referee) {
        if (referee.getStrike() == 3) {
            System.out.println(printStrike(referee));
            return WINNING_MESSAGE;
        }

        if (hasResult(referee.getStrike()) && hasResult(referee.getBall())) {
            return printBallCount(referee);
        }

        if (hasResult(referee.getBall()) && !hasResult(referee.getStrike())) {
            return printBall(referee);
        }

        if (hasResult(referee.getStrike()) && !hasResult(referee.getBall())) {
            return printStrike(referee);
        }

        return NOTHING;
    }

    private static boolean hasResult(int numbers) {
        if (numbers > 0) {
            return true;
        }
        return false;
    }

    private static String printStrike(Referee result) {
        return String.format(STRIKE_FORMAT, result.getStrike());
    }

    private static String printBall(Referee result) {
        return String.format(BALL_FORMAT, result.getBall());
    }

    private static String printBallCount(Referee result) {
        return String.format(BALL_COUNT_FORMAT, result.getStrike(), result.getBall());
    }
}

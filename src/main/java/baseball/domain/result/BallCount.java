package baseball.domain.result;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

package baseball.domain;

public class Player {
    private final BaseballNumber baseballNumbers;

    private Player(BaseballNumber baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static Player inputBaseballNumber(BaseballNumber baseballNumber) {
        return new Player(baseballNumber);
    }

    public BaseballNumber getBaseballNumbers() {
        return baseballNumbers;
    }
}

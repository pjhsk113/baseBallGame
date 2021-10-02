package baseball.domain;

public class GameHost {
    private final BaseballNumber targetNumbers;

    private GameHost(BaseballNumber targetNumbers) {
        this.targetNumbers = targetNumbers;
    }

    public static GameHost createTargetNumbers() {
        return new GameHost(NumberGenerator.generateNumber());
    }

    public BaseballNumber getTargetNumbers() {
        return targetNumbers;
    }
}

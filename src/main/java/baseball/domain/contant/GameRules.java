package baseball.domain.contant;

public enum GameRules {
    START_INCLUSIVE(1),
    END_INCLUSIVE(9),
    SIZE(3);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}

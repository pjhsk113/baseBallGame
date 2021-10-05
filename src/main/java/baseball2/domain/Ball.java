package baseball2.domain;

import baseball2.contant.GameRules;

public class Ball {
    private int number;
    private int position;

    private Ball(int number, int position) {
        validator(number, position);
        this.number = number;
        this.position = position;
    }

    public static Ball of(int number, int position) {
        return new Ball(number, position);
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    private void validator(int number, int position) {
        validateNumberRange(number);
        validatePosition(position);
    }

    private void validateNumberRange(int number) {
        if (number < GameRules.START_INCLUSIVE.value() || number > GameRules.END_INCLUSIVE.value()) {
            throw new IllegalArgumentException("범위 벗어남");
        }
    }

    private void validatePosition(int position) {
        if (position > GameRules.SIZE.value()) {
            throw new IllegalArgumentException("입력은 3자리 수만 가능");
        }
    }
}

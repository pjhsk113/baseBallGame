package baseball.exception;

import baseball.contant.GameRules;

import java.util.List;
import java.util.Set;

public class BaseballExceptionHandler {
    private static final String DUPLICATE_NUMBER_OR_INVALID_NUMBER = "[ERROR] 숫자에 중복이 존재하거나 잘못 입력하셨습니다.";
    private static final String OUT_OF_RANGE_NUMBER = "[ERROR] 입력 범위에 벗어난 숫자입니다. 입력 가능한 숫자 범위: 1 ~ 9";
    private static final String INVALID_INPUT_SIZE = "[ERROR] 입력한 숫자가 너무 많거나 범위를 벗어났습니다. 1 ~ 9 사이의 숫자 3개를 입력해주세요.";
    private static final String INVALID_GAME_RULES = "[ERROR] 게임 규칙 설정 상태가 올바르지 않아 게임을 진행할 수 없습니다.";

    private BaseballExceptionHandler() {
    }

    public static void validator(Set<Integer> baseBallNumbers) {
        validateDuplicateNumber(baseBallNumbers);
        validateNumberRange(baseBallNumbers);
    }

    public static void validateInputSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() > GameRules.SIZE.value()) {
            throw new IllegalArgumentException(INVALID_INPUT_SIZE);
        }
    }

    public static void validateGameRules() {
        int range = GameRules.END_INCLUSIVE.value() - GameRules.START_INCLUSIVE.value();

        if (range < GameRules.SIZE.value()) {
            throw new IllegalStateException(INVALID_GAME_RULES);
        }
    }

    private static void validateDuplicateNumber(Set<Integer> baseBallNumbers) {
        if (baseBallNumbers.size() != GameRules.SIZE.value()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_OR_INVALID_NUMBER);
        }
    }

    private static void validateNumberRange(Set<Integer> baseBallNumbers) {
        for (Integer number : baseBallNumbers) {
            if (number < GameRules.START_INCLUSIVE.value() || number > GameRules.END_INCLUSIVE.value()) {
                throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
            }
        }
    }

}

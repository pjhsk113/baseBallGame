package baseball.domain;

import baseball.domain.contant.GameRules;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {
    private static final String DUPLICATE_NUMBER_OR_INVALID_NUMBER = "숫자에 중복이 존재하거나 잘못 입력하셨습니다.";
    private static final String OUT_OF_RANGE_NUMBER = "입력 범위에 벗어난 숫자입니다. 입력 가능한 숫자 범위: 1 ~ 9";
    private static final String INVALID_INPUT_SIZE = "입력한 숫자가 너무 많거나 범위를 벗어났습니다. 1 ~ 9 사이의 숫자 3개를 입력해주세요.";

    private final Set<Integer> baseBallNumbers;

    private BaseballNumber(Set<Integer> baseBallNumbers) {
        validator(baseBallNumbers);
        this.baseBallNumbers = baseBallNumbers;
    }

    public static BaseballNumber of(List<Integer> numbers) {
        validateInputSize(numbers);
        return new BaseballNumber(new LinkedHashSet<>(numbers));
    }

    public Set<Integer> getBaseBallNumbers() {
        return baseBallNumbers;
    }

    private void validator(Set<Integer> baseBallNumbers) {
        validateDuplicateNumber(baseBallNumbers);
        validateNumberRange(baseBallNumbers);
    }

    private static void validateInputSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() > GameRules.SIZE.value()) {
            throw new IllegalArgumentException(INVALID_INPUT_SIZE);
        }
    }

    private void validateDuplicateNumber(Set<Integer> baseBallNumbers) {
        if (baseBallNumbers.size() != GameRules.SIZE.value()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_OR_INVALID_NUMBER);
        }
    }

    private void validateNumberRange(Set<Integer> baseBallNumbers) {
        for (Integer number : baseBallNumbers) {
            if (number < GameRules.START_INCLUSIVE.value() || number > GameRules.END_INCLUSIVE.value()) {
                throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
            }
        }
    }
}

package baseball.domain;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumber {
    private static final String DUPLICATE_NUMBER_OR_INVALID_NUMBER = "숫자에 중복이 존재하거나 잘못 입력하셨습니다.";
    private static final String OUT_OF_RANGE_NUMBER = "입력 범위에 벗어난 숫자입니다. 입력 가능한 숫자 범위: 1 ~ 9";

    private final Set<Integer> baseBallNumbers;

    private BaseBallNumber(Set<Integer> baseBallNumbers) {
        validator(baseBallNumbers);
        this.baseBallNumbers = baseBallNumbers;
    }

    public static BaseBallNumber of(List<Integer> numbers) {
        return new BaseBallNumber(new LinkedHashSet<>(numbers));
    }

    private void validator(Set<Integer> baseBallNumbers) {
        validateDuplicateNumber(baseBallNumbers);
        validateNumberRange(baseBallNumbers);

    }

    private void validateDuplicateNumber(Set<Integer> baseBallNumbers) {
        if (baseBallNumbers.size() != 3) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_OR_INVALID_NUMBER);
        }
    }

    private void validateNumberRange(Set<Integer> baseBallNumbers) {
        for (Integer number : baseBallNumbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
            }
        }
    }
}

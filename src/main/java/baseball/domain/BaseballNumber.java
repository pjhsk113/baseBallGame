package baseball.domain;

import baseball.exception.BaseballExceptionHandler;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {
    private final Set<Integer> baseBallNumbers;

    private BaseballNumber(Set<Integer> baseBallNumbers) {
        BaseballExceptionHandler.validator(baseBallNumbers);
        this.baseBallNumbers = baseBallNumbers;
    }

    public static BaseballNumber of(List<Integer> numbers) {
        BaseballExceptionHandler.validateInputSize(numbers);
        return new BaseballNumber(new LinkedHashSet<>(numbers));
    }

    public int valueOf(int index) {
        return (Integer) baseBallNumbers.toArray()[index];
    }

    public boolean hasNumber(int pickNumber) {
        return baseBallNumbers.contains(pickNumber);
    }
}

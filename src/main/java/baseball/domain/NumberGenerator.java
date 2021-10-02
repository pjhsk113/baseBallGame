package baseball.domain;

import newtstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private NumberGenerator() {
    }

    public static BaseballNumber generateNumber() {
        List<Integer> baseballNumbers = new ArrayList<>();

        while (baseballNumbers.size() < 3) {
            baseballNumbers = addNonDuplicateNumber(baseballNumbers, Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }
        return BaseballNumber.of(baseballNumbers);
    }

    private static List<Integer> addNonDuplicateNumber(List<Integer> baseballNumbers, int randomNumber) {
        if (!baseballNumbers.contains(randomNumber)) {
            baseballNumbers.add(randomNumber);
        }
        return baseballNumbers;
    }
}

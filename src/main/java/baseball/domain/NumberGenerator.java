package baseball.domain;

import baseball.contant.GameRules;
import baseball.exception.BaseballExceptionHandler;
import newtstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private NumberGenerator() {
    }

    public static BaseballNumber generateNumber() {
        List<Integer> baseballNumbers = new ArrayList<>();

        while (baseballNumbers.size() < GameRules.SIZE.value()) {
            BaseballExceptionHandler.validateGameRules();
            int randomNumber = Randoms.pickNumberInRange(GameRules.START_INCLUSIVE.value(), GameRules.END_INCLUSIVE.value());
            baseballNumbers = addNonDuplicateNumber(baseballNumbers, randomNumber);
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

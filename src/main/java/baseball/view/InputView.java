package baseball.view;

import baseball.domain.BaseBallNumber;
import newtstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요.";

    private InputView() {
    }

    public static BaseBallNumber enterNumber() {
        System.out.println(ENTER_NUMBER_MESSAGE);
        return BaseBallNumber.of(convertList(Console.readLine()));
    }

    private static List<Integer> convertList(String numbers) {
        List<Integer> baseBallNumbers = new ArrayList<>();

        for (String number : numbers.split("")) {
            baseBallNumbers.add(Integer.parseInt(number));
        }

        return baseBallNumbers;
    }
}

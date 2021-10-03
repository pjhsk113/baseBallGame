package baseball.view;

import baseball.domain.BaseballNumber;
import newtstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String TRY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String DELIMITER = "";

    private InputView() {
    }

    public static BaseballNumber enterNumber() {
        System.out.println(ENTER_NUMBER_MESSAGE);
        try {
             return BaseballNumber.of(convertList(Console.readLine()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return enterNumber();
        }
    }

    public static int enterNumberTryAgain() {
        System.out.println(TRY_AGAIN);
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> convertList(String numbers) {
        List<Integer> baseBallNumbers = new ArrayList<>();

        for (String number : numbers.split(DELIMITER)) {
            baseBallNumbers.add(Integer.parseInt(number));
        }
        return baseBallNumbers;
    }
}

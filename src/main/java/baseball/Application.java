package baseball;

import baseball.domain.BaseballGame;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        int coin = 1;
        while(coin == 1) {
            new BaseballGame().play();
            coin = InputView.enterNumberTryAgain();
        }
    }
}

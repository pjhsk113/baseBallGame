package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    public void play() {
        // 게임 호스트는 타겟 넘버(임의의 숫자 3개)를 설정한다.
        GameHost targetNumbers = GameHost.createTargetNumbers();

        boolean isAnswer = false;
        while(!isAnswer) {
            // 플레이어는 숫자(임의의 숫자 3개)를 입력한다.
            Player playerNumbers = Player.pickBaseballNumber(InputView.enterNumber());

            // 심판에게 결과를 요청한다.
            Referee referee = Referee.of(targetNumbers, playerNumbers);

            // 판단 결과를 출력한다.
            OutputView.printResult(referee);
            isAnswer = referee.isAllStrike();
        }
    }
}

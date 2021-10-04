package baseball.domain.result;

import baseball.domain.BaseballNumber;
import baseball.domain.GameHost;
import baseball.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class JudgmentMachineTest {
    private BallCount ballCount;

    @BeforeEach
    void setUp() {
        GameHost targetNumber = GameHost.of(BaseballNumber.of(Arrays.asList(6,3,8)));
        Player inputNumber = Player.pickBaseballNumber(BaseballNumber.of(Arrays.asList(3,8,7)));
        ballCount = JudgmentMachine.judgmentResult(targetNumber, inputNumber);
    }

    @Test
    void test() {
    }

    @DisplayName("올바른 스트라이크 개수를 카운트")
    @Test
    void strikeJudgmentTest() {
        assertThat(ballCount.getStrike()).isEqualTo(0);
    }

    @DisplayName("올바른 볼 개수를 카운트")
    @Test
    void ballJudgmentTest() {
        assertThat(ballCount.getBall()).isEqualTo(2);
    }
}
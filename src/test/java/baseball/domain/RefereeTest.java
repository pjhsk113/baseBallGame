package baseball.domain;

import baseball.domain.result.BallCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @DisplayName("심판은 올바른 판정 결과를 반환 해야한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void refereeTest(List<Integer> target, List<Integer> pickNumber, BallCount ballCount) {
        GameHost host = GameHost.of(BaseballNumber.of(target));
        Player player = Player.pickBaseballNumber(BaseballNumber.of(pickNumber));

        assertThat(Referee.of(host, player).getStrike()).isEqualTo(ballCount.getStrike());
        assertThat(Referee.of(host, player).getBall()).isEqualTo(ballCount.getBall());
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 8), Arrays.asList(8, 1, 2), new BallCount(0, 3)),
                Arguments.of(Arrays.asList(1, 6, 9), Arrays.asList(1, 2, 8), new BallCount(1, 0)),
                Arguments.of(Arrays.asList(2, 3, 5), Arrays.asList(7, 4, 8), new BallCount(0, 0)),
                Arguments.of(Arrays.asList(1, 9, 8), Arrays.asList(4, 1, 8), new BallCount(1, 1)),
                Arguments.of(Arrays.asList(1, 3, 4), Arrays.asList(1, 3, 7), new BallCount(2, 0)),
                Arguments.of(Arrays.asList(1, 4, 6), Arrays.asList(1, 4, 6), new BallCount(3, 0))
        );
    }

    @DisplayName("숫자 3개를 정확히 맞췄을 경우 테스트")
    @ParameterizedTest
    @MethodSource("generateStrikeData")
    void isAllStrikeTest(List<Integer> target, List<Integer> pickNumber, boolean isAllStrike) {
        GameHost host = GameHost.of(BaseballNumber.of(target));
        Player player = Player.pickBaseballNumber(BaseballNumber.of(pickNumber));

        assertThat(Referee.of(host, player).isAllStrike()).isEqualTo(isAllStrike);
        assertThat(Referee.of(host, player).isAllStrike()).isEqualTo(isAllStrike);
    }

    private static Stream<Arguments> generateStrikeData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 8), Arrays.asList(8, 1, 2), false),
                Arguments.of(Arrays.asList(1, 6, 9), Arrays.asList(1, 6, 9), true),
                Arguments.of(Arrays.asList(1, 4, 6), Arrays.asList(1, 4, 6), true)
        );
    }
}
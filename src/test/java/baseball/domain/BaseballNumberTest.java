package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("잘못된 범위의 숫자가 입력됐을 때 exception 테스트")
    @ParameterizedTest
    @MethodSource("generateOutOfRangeBaseBallNumberData")
    void outOfRangeNumberTest(List<Integer> numbers) {
        assertThatThrownBy(() -> {
            BaseballNumber.of(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    private static Stream<Arguments> generateOutOfRangeBaseBallNumberData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 0, 8)),
                Arguments.of(Arrays.asList(1, 2, 10)),
                Arguments.of(Arrays.asList(20, 30, 10)),
                Arguments.of(Arrays.asList(1, 9, 1,2)),
                Arguments.of(Arrays.asList(10, 1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 6))
        );
    }

    @DisplayName("중복된 숫자가 입력됐을 때 exception 테스트")
    @ParameterizedTest
    @MethodSource("generateDuplicateBaseBallNumberData")
    void duplicateNumberTest(List<Integer> numbers) {
        assertThatThrownBy(() -> {
            BaseballNumber.of(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    private static Stream<Arguments> generateDuplicateBaseBallNumberData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 1, 1)),
                Arguments.of(Arrays.asList(1, 2, 2)),
                Arguments.of(Arrays.asList(3, 3, 2)),
                Arguments.of(Arrays.asList(1, 2, 1))
        );
    }
}

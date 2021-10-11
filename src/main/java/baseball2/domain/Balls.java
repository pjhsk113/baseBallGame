package baseball2.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of(String[] inputNumber) {
        return new Balls(createBalls(inputNumber));
    }

    private static List<Ball> createBalls(String[] inputNumber) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < inputNumber.length; i++) {
            validateDuplicateBall(balls, Integer.parseInt(inputNumber[i]));
            balls.add(Ball.of(Integer.parseInt(inputNumber[i]), i));
        }

        return balls;
    }

    private static void validateDuplicateBall(List<Ball> balls, int number) {
        for (Ball ball : balls) {
            isDuplicateNumber(number, ball);
        }
    }

    private static void isDuplicateNumber(int number, Ball ball) {
        if (ball.getNumber() == number) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }
}

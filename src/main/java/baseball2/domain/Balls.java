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
            balls.add(Ball.of(Integer.parseInt(inputNumber[i]), i));
        }
    }
}

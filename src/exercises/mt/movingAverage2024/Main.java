package exercises.mt.movingAverage2024;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MovingAverageCalculator calculator = new MovingAverageCalculator();

        List<Double> result = calculator.calculateParallelMovingAverage(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 4);

        System.out.println(result);

    }
}

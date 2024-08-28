package exercises.mt.movingAverage2024;

import java.util.ArrayList;
import java.util.List;

public class MovingAverageCalculator {

    public List<Double> calculateParallelMovingAverage(List<Integer> data, int windowSize) throws InterruptedException {
        List<Double> result = new ArrayList<>();

        int threadNumber = data.size() - windowSize + 1;
        Thread[] threads = new Thread[threadNumber];

        for (int i = 0; i < threadNumber; i++){
            final int firstNumber = i;

            threads[i] = new Thread(new Runnable() {
                public void run() {
                    double sum = 0;
                    for(int j = firstNumber; j < windowSize+firstNumber; j++){
                        sum += data.get(j);
                    }

                    result.add(sum/windowSize);
                }
            });
            threads[i].start();
        }

        for(int i = 0; i < threadNumber; i++){
            threads[i].join();
        }

        return  result;
    }
}

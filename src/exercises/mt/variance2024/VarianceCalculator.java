package exercises.mt.variance2024;

import java.util.ArrayList;
import java.util.List;

public class VarianceCalculator {
    public static double calculateParallelVariance(List<Integer> list, int s) throws Exception{
        Double[] localSumMeans = new Double[s];
        Double[] localSums = new Double[s];
        double result = 0;
        double mean = 0;
        int intervalSize = list.size()/s;
        Thread[] threads = new Thread[s];

        for(int i=0; i<s; i++){
            final int index = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    double localSum = 0;
                    int start = index * intervalSize;
                    int end = Math.min(list.size(), start+intervalSize);

                    for(int j = start; j < end; j++){
                        localSum += list.get(j);
                    }

                    localSumMeans[index] = localSum;
                }
            });
            threads[i].start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        for(Double number : localSumMeans){
            mean += number;
        }

        mean = mean/list.size();


        for(int i=0; i<s; i++){
            final int index = i;
            final double finalMean = mean;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    double localSum = 0;
                    int start = index * intervalSize;
                    int end = Math.min(list.size(), start+intervalSize);

                    for(int j = start; j < end; j++){
                        localSum += (list.get(j)- finalMean)*(list.get(j) - finalMean);
                    }
                    localSums[index] = localSum;
                }
            });
            threads[i].start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        for (Double number: localSums){
            result += number;
        }

        return result/list.size();
    }
}

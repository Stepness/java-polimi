package exercises.mt.minof2021;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 0, 5, 6);

        int s = 2;
        int result = minOf(numbers, s);
        System.out.println(result);
    }

    public static int minOf(List<Integer> l, int s) throws InterruptedException {
        Thread[] threads = new Thread[s];
        int sequenceSize = l.size()/s;
        Integer[] localMinimums = new Integer[s];
        int result;

        for(int i = 0; i < s; i++){
            final int index = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    int start = index * sequenceSize;
                    int end = Math.min(l.size(), start + sequenceSize);
                    int localMinimum = l.get(index);
                    for (int j = start; j < end; j ++) {
                        if(l.get(j) < localMinimum){
                            localMinimum = l.get(j);
                        }
                    }
                    localMinimums[index] = localMinimum;
                }});
            threads[i].start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        result = localMinimums[0];
        for(int i = 1; i < localMinimums.length; i++){
            if (localMinimums[i]<result){
                result = localMinimums[i];
            }
        }

        return result;
    }
}

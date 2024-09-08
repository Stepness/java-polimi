package exercises.mt.minof2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int s = 2;
        int result = minOf(numbers, s);
        System.out.println(result);
    }

    public static int minOf(List<Integer> l, int s) throws InterruptedException {
        Thread[] threads = new Thread[s];
        int sequenceSize = l.size()/s;
        List<Integer> localMinimums = new ArrayList<>();
        int result;

        for(int i = 0; i < s; i++){
            final int index = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    int localMinimum = l.get(index);
                    for (int j = index; j < l.size(); j += sequenceSize) {
                        if(l.get(j) < localMinimum){
                            localMinimum = l.get(j);
                        }
                    }
                    localMinimums.add(localMinimum);
                }});
            threads[i].start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        result = localMinimums.get(0);
        for(int i = 1; i < localMinimums.size(); i++){
            if (localMinimums.get(i)<result){
                result = localMinimums.get(i);
            }
        }

        return result;
    }
}

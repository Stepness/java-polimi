package exercises.mt.scicommons2023;

import exercises.mt.document.Autore;

import java.util.ArrayList;
import java.util.List;

public class SciCommons {
    public static List<List<Boolean>> isGreater(List<List<Integer>> a, List<List<Integer>> b) throws InterruptedException {
        int numColumns = a.size();
        Thread[] threads = new Thread[numColumns];
        List<List<Boolean>> result = new ArrayList<>();

        for(int i = 0; i < a.size(); i++){
            final List<Integer> column = a.get(i);
            final int columnIndex = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    List<Boolean> columnResult = new ArrayList<>();
                    for (int j = 0; j < column.size(); j++ ){
                        columnResult.add(a.get(columnIndex).get(j) > b.get(columnIndex).get(j));
                    }
                    result.add(columnIndex, columnResult);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        return result;
    }
}

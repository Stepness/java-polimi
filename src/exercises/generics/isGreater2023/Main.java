package exercises.generics.isGreater2023;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> matrixA = new ArrayList<>();
        matrixA.add(List.of(10, 20, 30));
        matrixA.add(List.of(40, 50, 60));

        List<List<Integer>> matrixB = new ArrayList<>();
        matrixB.add(List.of(5, 25, 15));
        matrixB.add(List.of(35, 45, 65));

        List<List<Boolean>> result = SciCommons.isGreater(matrixA, matrixB);

        for (List<Boolean> row : result) {
            System.out.println(row);
        }
    }
}

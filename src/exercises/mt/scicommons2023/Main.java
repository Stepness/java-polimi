package exercises.mt.scicommons2023;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<List<Integer>> a = List.of(
                List.of(1, 5, 99),
                List.of(-2, 14, 7),
                List.of(4, 9, 11)
        );

        List<List<Integer>> b = List.of(
                List.of(3, 1, 99),
                List.of(4, 7, 10),
                List.of(14, -6, 3)
        );


        System.out.println(SciCommons.isGreater(a, b));
    }
}

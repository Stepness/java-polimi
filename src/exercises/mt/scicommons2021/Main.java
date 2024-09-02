package exercises.mt.scicommons2021;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer[][] matrix = {
                {4, 4, 1, 2},
                {6, 6, 3, 4},
                {8, 8, 7, 7},
                {12, 12, 7, 7}
        };


        Float[][] result = SciCommons.downScale(matrix);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

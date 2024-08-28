package exercises.mt.scicommons2022;

public class Main {
    public static void main(String[] args) throws Exception {

        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Integer[] result = SciCommons.sample(matrix);

        for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
        }
    }
}

package exercises.generics.matrix2022;

public class Main {
    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(3, 3);

        matrix.set(0, 0, 3);
        int result = matrix.get(0, 0);
        System.out.println(result);
    }
}

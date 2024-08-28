package exercises.mt.scicommons2022;
import java.util.Random;

public class SciCommons {
    public static Integer[] sample(Integer[][] matrix) throws Exception {

        if(!isQuadrata(matrix)){
            throw new Exception("Invalid matrix");
        }

        int numThreads = matrix.length*2+2;
        Integer[] result = new Integer[numThreads];
        Thread[] threads = new Thread[numThreads];
        Random rnd = new Random();


        for (int i = 0; i < matrix.length; i++){
            final int rowIndex = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    int randomInt = rnd.nextInt(matrix.length);
                    result[rowIndex] = matrix[rowIndex][randomInt];
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < matrix.length; i++){
            final int colIndex = i;
            threads[matrix.length+i] = new Thread(new Runnable() {
                public void run() {
                    int randomInt = rnd.nextInt(matrix.length);
                    result[matrix.length+colIndex] = matrix[randomInt][colIndex];
                }
            });
            threads[matrix.length+i].start();
        }


        //Diagonale principale
        threads[matrix.length*2] = new Thread(new Runnable() {
            public void run() {
                int randomInt = rnd.nextInt(matrix.length);
                result[matrix.length*2] = matrix[randomInt][randomInt];
            }
        });

        threads[matrix.length*2].start();

        //Diagonale secondaria
        threads[matrix.length*2+1] = new Thread(new Runnable() {
            public void run() {
                int randomInt = rnd.nextInt(matrix.length);
                result[matrix.length*2+1] = matrix[randomInt][matrix.length - randomInt - 1];
            }
        });

        threads[matrix.length*2+1].start();


        for(int i = 0; i < numThreads; i++){
            threads[i].join();
        }

        return result;
    }

    public static boolean isQuadrata(Integer[][] matrix) {

        int height = 0;
        int lenght = 0;

        for (int i = 0; i < matrix.length; i++){
            height++;
        }

        for (int i = 0; i < matrix[0].length; i++){
            lenght++;
        }

        return height == lenght;
    }
}

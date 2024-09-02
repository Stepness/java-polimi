package exercises.mt.scicommons2021;

public class SciCommons {

    public static Float[][] downScale(Integer[][] matrix) throws InterruptedException {
        int xsize = matrix.length;
        int ysize = matrix[0].length;

        if (xsize % 2 != 0 || ysize % 2 != 0) {
            return null;
        }

        Thread[] threads = new Thread[xsize / 2 * ysize / 2];

        Float[][] result = new Float[xsize / 2][ysize / 2];

        int threadIndex = 0;

        for (int i = 0; i < xsize; i += 2) {
            for (int j = 0; j < ysize; j += 2) {
                final int iIndex = i;
                final int jIndex = j;
                threads[threadIndex] = new Thread(new Runnable() {
                    public void run() {
                        int sum = 0;
                        sum += matrix[iIndex][jIndex];
                        sum += matrix[iIndex + 1][jIndex];
                        sum += matrix[iIndex][jIndex + 1];
                        sum += matrix[iIndex + 1][jIndex + 1];
                        result[iIndex / 2][jIndex / 2] =  ((float) sum / 4);
                    }
                });
                threads[threadIndex].start();
                threadIndex++;
            }
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return result;

    }
}
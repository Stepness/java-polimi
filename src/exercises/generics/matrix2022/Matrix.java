package exercises.generics.matrix2022;

import exercises.mt.bank2022.Operator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Matrix <T> {
    List<List<T>> matrix = new ArrayList<>();

    public Matrix(int sizeX, int sizeY){
        for (int i = 0; i < sizeX; i++){
            List<T> column = new ArrayList<>();
            for (int j = 0; j < sizeY; j++){
                column.add(null);
            }
            matrix.add(column);
        }
    }

    public T get(int x, int y){
        return matrix.get(x).get(y);
    }

    public void set(int x, int y, T value){
        matrix.get(x).set(y, value);
    }
}

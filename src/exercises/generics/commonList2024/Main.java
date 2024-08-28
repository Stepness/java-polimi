package exercises.generics.commonList2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(10, 330, 310));

        List<Integer> result = method(list, list2);

    }

    public static <T> List<T> method(List<T> list1, List<T> list2){
        List<T> result = new ArrayList<>();

        for (T item : list1){
            if(list2.contains(item)){
                result.add(item);
            }
        }

        return result;
    }
}

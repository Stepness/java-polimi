package exercises.generics.isGreater2023;

import java.util.ArrayList;
import java.util.List;

public class SciCommons {
    public static <T extends Comparable<T>> List<List<Boolean>> isGreater(List<List<T>> listA, List<List<T>> listB){
        List<List<Boolean>> result = new ArrayList<>();

        for(int i = 0; i < listA.size(); i++){
            List<Boolean> columnResult = new ArrayList<>();
            for(int j = 0; j < listA.get(i).size(); j++){
                T firstItem =  listA.get(i).get(j);
                T secondItem =  listB.get(i).get(j);
                if(firstItem.compareTo(secondItem) > 0){
                    columnResult.add(true);
                }
                else{
                    columnResult.add(false);
                }
            }
            result.add(columnResult);
        }

        return result;
    }
}

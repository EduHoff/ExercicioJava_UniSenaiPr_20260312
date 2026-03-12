package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArrayUtils {

    public static <T extends Comparable<T>> T max(T[] array){      
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");  
        }

        T max = array[0];
        for (T t : array) {
            if(t.compareTo(max) > 0){
                max = t;
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T min(T[] array){      
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        T min = array[0];
        for (T t : array) {
            if(t.compareTo(min) < 0){
                min = t;
            }
        }
        return min;
    }

    public static <T extends Number> double mean(T[] array){
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        double sum = 0;
        for (T t : array) {
            sum += t.doubleValue();
        }

        double mean = sum / array.length;

        return mean;
    }

    public static <T> ArrayList<T> mode(T[] array){
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        Map<T, Integer> aux_map = new HashMap<>();

        for (T t : array) {
            if(aux_map.containsKey(t)){
                int current_value = aux_map.get(t);
                aux_map.put(t, current_value+1);
            }else{
                aux_map.put(t, 1);
            }
        }

        int max = Collections.max(aux_map.values());

        ArrayList<T> mode = new ArrayList<>();
        
        for (Map.Entry<T, Integer> entry : aux_map.entrySet()){
            if (entry.getValue() == max) {
                mode.add(entry.getKey());
            }
        }
        
        return mode;
    }


}

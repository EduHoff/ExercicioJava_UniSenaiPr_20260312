package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.Validation;

public class StatisticsUtils {

    // MÁXIMO
    public static <T extends Comparable<T>> T max(T[] array){
        return max(Arrays.asList(array));
    }

    public static <T extends Comparable<T>> T max(Collection<T> collection){      
        
        Validation.IllegalCollection(collection);

        T max = collection.iterator().next();
        for (T t : collection) {
            if(t.compareTo(max) > 0){
                max = t;
            }
        }

        return max;
    }

    // MÍNIMO
    public static <T extends Comparable<T>> T min(T[] array){
        return min(Arrays.asList(array));
    }

    public static <T extends Comparable<T>> T min(Collection<T> collection){      
        
        Validation.IllegalCollection(collection);

        T min = collection.iterator().next();
        for (T t : collection) {
            if(t.compareTo(min) < 0){
                min = t;
            }
        }

        return min;
    }

    // MÉRDIA ARITMETICA SIMPLES
    public static <T extends Number> double mean(T[] array){
        return mean(Arrays.asList(array));
    }

    public static <T extends Number> double mean(Collection<T> collection){

        Validation.IllegalCollection(collection);

        double sum = 0;
        for (T t : collection) {
            sum += t.doubleValue();
        }

        double mean = sum / collection.size();

        return mean;
    }

    // MODA
    public static <T> List<T> mode(T[] array){
        return mode(Arrays.asList(array));
    }

    public static <T> List<T> mode(Collection<T> collection){
        
        Validation.IllegalCollection(collection);

        Map<T, Integer> aux_map = new HashMap<>();

        for (T t : collection) {
            aux_map.put(t, aux_map.getOrDefault(t, 0) + 1);
        }

        int max = StatisticsUtils.max(aux_map.values());

        List<T> mode = new ArrayList<>();
        
        for (Map.Entry<T, Integer> entry : aux_map.entrySet()){
            if (entry.getValue() == max) {
                mode.add(entry.getKey());
            }
        }
        
        return mode;
    }

    // VARIÂNCIA
    public static <T extends Number> double variance(T[] array){
        return standardDeviation(Arrays.asList(array));
    }

    public static <T extends Number> double variance(Collection<T> collection){

        Validation.IllegalCollection(collection);
        
        double mean = StatisticsUtils.mean(collection);

        double variance = collection.stream()
            .mapToDouble(x -> Math.pow(x.doubleValue() - mean, 2))
            .average()
            .orElse(0.0);

        return variance;
    }


    
    // DESVIO PADRÃO
    public static <T extends Number> double standardDeviation(T[] array){
        return standardDeviation(Arrays.asList(array));
    }

    public static <T extends Number> double standardDeviation(Collection<T> collection){

        Validation.IllegalCollection(collection);

        return Math.sqrt(StatisticsUtils.variance(collection));
    }
}

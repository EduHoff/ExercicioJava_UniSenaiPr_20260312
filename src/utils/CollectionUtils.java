package utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.Validation;

public class CollectionUtils {

    // Remove elementos repetidos
    public static <T> List<T> removeDuplicates(T[] array){
        Validation.IllegalArray(array);
        return removeDuplicates(Arrays.asList(array));
    }

    public static <T> List<T> removeDuplicates(Collection<T> collection){

        Validation.IllegalCollection(collection);

        List<T> list = collection.stream()
            .distinct()
            .collect(Collectors.toList());
        
        return list;
    }

    // Inverte elementos

    public static <T> T[] invertArray(T[] array){
        Validation.IllegalArray(array);

        int middle_index = array.length / 2;

        for(int i=0; i<middle_index; i++){
            T aux = array[i];
            array[i] = array[array.length-(1+i)];
            array[array.length-(1+i)] = aux;
        }

        return array;
    }

    public static <T> T[] invertCollection(Collection<T> collection){
        Validation.IllegalCollection(collection);
        return null;
    }

}
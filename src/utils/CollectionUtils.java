package utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.Validation;

public class CollectionUtils {

    // Remove elementos repetidos
    public static <T> List<T> removeDuplicates(T[] array){
        return removeDuplicates(Arrays.asList(array));
    }

    public static <T> List<T> removeDuplicates(Collection<T> collection){

        Validation.IllegalCollection(collection);

        List<T> list = collection.stream()
            .distinct()
            .collect(Collectors.toList());
        
        return list;
    }

}
package exceptions;

import java.util.Collection;
import java.util.List;

public class Validation {

    public static void IllegalCollection(Collection<?> collection){
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Collection cannot be null or empty");  
        }
    }

    public static void IllegalList(List<?> list){
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");  
        }
    }

    public static <T> void IllegalArray(T[] array){
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");  
        }
    }

}

package exceptions;

import java.util.Collection;

public class Validation {

    public static void IllegalCollection(Collection<?> collection){
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Collection cannot be null or empty");  
        }
    }

}

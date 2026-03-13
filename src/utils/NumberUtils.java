package utils;

import java.util.Arrays;
import java.util.Collection;

public class NumberUtils {

    private static void IllegalCollection(Collection<?> collection){
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Collection cannot be null or empty");  
        }
    }

    // Quantidade números pares

    public static <T extends Number> long countEven(T[] array){
        return countEven(Arrays.asList(array));
    }

    public static <T extends Number> long countEven(Collection<T> collection){

        NumberUtils.IllegalCollection(collection);

        long sum = collection.stream()
                        .mapToDouble(x -> x.longValue())
                        .filter(x -> x % 2 == 0)
                        .count();

        return sum;
    }

    // Quantidade números ímpares

    public static <T extends Number> long countOdd(T[] array){
        return countOdd(Arrays.asList(array));
    }

    public static <T extends Number> long countOdd(Collection<T> collection){

        NumberUtils.IllegalCollection(collection);

        long sum = collection.stream()
                        .mapToDouble(x -> x.longValue())
                        .filter(x -> x % 2 != 0)
                        .count();

        return sum;
    }

    // Verificador de primo

    public static boolean isPrime(int num){

        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }

}

package utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import exceptions.Validation;

public class NumberUtils {

    // Contador números pares
    public static <T extends Number> long countEven(T[] array){
        Validation.IllegalArray(array);
        return countEven(Arrays.asList(array));
    }

    public static <T extends Number> long countEven(Collection<T> collection){

        Validation.IllegalCollection(collection);

        long sum = collection.stream()
            .mapToDouble(x -> x.longValue())
            .filter(x -> x % 2 == 0)
            .count();
        return sum;
    }

    // Contador números ímpares
    public static <T extends Number> long countOdd(T[] array){
        Validation.IllegalArray(array);
        return countOdd(Arrays.asList(array));
    }

    public static <T extends Number> long countOdd(Collection<T> collection){

        Validation.IllegalCollection(collection);

        long sum = collection.stream()
            .mapToDouble(x -> x.longValue())
            .filter(x -> x % 2 != 0)
            .count();
        return sum;
    }

    // Contador números positivos
    public static <T extends Number> long countPositive(T[] array){
        Validation.IllegalArray(array);
        return countPositive(Arrays.asList(array));
    }

    public static <T extends Number> long countPositive(Collection<T> collection){

        Validation.IllegalCollection(collection);

        long sum = collection.stream()
            .mapToDouble(x -> x.longValue())
            .filter(x -> x > 0)
            .count();
        return sum;
    }

    // Contador números negativos
    public static <T extends Number> long countNegative(T[] array){
        Validation.IllegalArray(array);
        return countNegative(Arrays.asList(array));
    }

    public static <T extends Number> long countNegative(Collection<T> collection){

        Validation.IllegalCollection(collection);

        long sum = collection.stream()
            .mapToDouble(x -> x.longValue())
            .filter(x -> x < 0)
            .count();
        return sum;
    }

    // Contador de zeros
    public static <T extends Number> long countZero(T[] array){
        Validation.IllegalArray(array);
        return countZero(Arrays.asList(array));
    }

    public static <T extends Number> long countZero(Collection<T> collection){

        Validation.IllegalCollection(collection);

        long sum = collection.stream()
            .mapToDouble(x -> x.longValue())
            .filter(x -> x == 0)
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

    // Verifica se é uma ordem crescente ou não
    public static <T extends Number> boolean isAscending(T[] array){
        return isAscending(Arrays.asList(array));
    }

    public static <T extends Number> boolean isAscending(List<T> list){

    for(int i = 0; i < list.size() - 1; i++){
        if(list.get(i).doubleValue() > list.get(i + 1).doubleValue()){
            return false;
        }
    }
        return true;
    }

    // Verifica se é uma ordem decrescente ou não 
    public static <T extends Number> boolean isDescending(T[] array){
        return isDescending(Arrays.asList(array));
    }

    public static <T extends Number> boolean isDescending(List<T> list){

    for(int i = 0; i < list.size() - 1; i++){
        if(list.get(i).doubleValue() < list.get(i + 1).doubleValue()){
            return false;
        }
    }
        return true;
    }

}

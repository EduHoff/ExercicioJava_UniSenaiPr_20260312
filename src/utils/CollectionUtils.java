package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
    public static <T> T[] invertList(T[] array){
        Validation.IllegalArray(array);
        invertList(Arrays.asList(array));
        return array;
    }

    public static <T> List<T> invertList(List<T> list){
        Validation.IllegalList(list);
        
        int middle_index = list.size() / 2;

        for(int i = 0; i < middle_index; i++){
            T aux = list.get(i);
            list.set(i, list.get(list.size() - (1 + i)));
            list.set(list.size() - (1 + i), aux);
        }

        return list;
    }

    // Pesquisar elementos
    public static <T> Map.Entry<Boolean, List<Integer>> searchList(T[] array, T x){
        Validation.IllegalArray(array);
        invertList(Arrays.asList(array));
        return searchList(Arrays.asList(array), x);
    }

    public static <T> Map.Entry<Boolean, List<Integer>> searchList(List<T> list, T x){
        Validation.IllegalList(list);


        List<Integer> aux = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(x)){
                aux.add(i);
            }
        }

        if(aux.isEmpty()){
            return Map.entry(false, aux);
        }else{
           return Map.entry(true, aux);
        }
    }
}
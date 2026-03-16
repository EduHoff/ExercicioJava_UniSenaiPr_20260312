package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import utils.CollectionUtils;
import utils.ConsoleUtils;

/* 
Leia um vetor de 10 inteiros e um número X. Informe se X está no vetor e em
quais posições aparece.
*/


public class Ex7 implements Exercise {

    private static final int ARRAY_SIZE = 10;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 7 ---\n");

        Integer[] array = new Integer[ARRAY_SIZE];
        int num_x = 0;

        int last_int = 0;
        while (last_int < ARRAY_SIZE) {
            try{

                for(int i=last_int; i<ARRAY_SIZE; i++){
                    System.out.println("Digite o "+(i+1)+"º número inteiro.");
                    System.out.print("||");
                    int num = sc.nextInt();
                    array[i] = num;
                    last_int = i + 1;
                    ConsoleUtils.clear();
                }
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            }
        }

        while (true) {
            try{
                System.out.println("Digite um número X inteiro.");
                System.out.print("||");
                num_x = sc.nextInt();
                break;
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            }
        }

        Map.Entry<Boolean, List<Integer>> result = CollectionUtils.searchList(array, num_x);

        ConsoleUtils.clear();
        System.out.println("Array: " + Arrays.toString(array));
        if(result.getKey()){
            System.out.println("Valor " + num_x + " foi encontrado no array!");
            System.out.println("Encontrado nos índices: " + result.getValue());
        }else{
            System.out.println("Valor " + num_x + " não foi encontrado no array!");
        }
    }
}
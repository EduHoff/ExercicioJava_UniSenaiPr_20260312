package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.CollectionUtils;
import utils.ConsoleUtils;

/* 
Escreva um programa que lê um vetor de 15 números inteiros e remove os
valores duplicados, exibindo o vetor resultante sem repetições.
*/

public class Ex4 implements Exercise {

    private static final int ARRAY_SIZE = 15;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 4 ---\n");

        Integer[] array = new Integer[ARRAY_SIZE];

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

        ConsoleUtils.clear();
        System.out.println("Array Original: " + Arrays.toString(array));
        System.out.println("Array Sem Duplicados: " + CollectionUtils.removeDuplicates(array));

    }
}
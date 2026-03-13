package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;
import utils.NumberUtils;

/* 
Leia um vetor de 10 inteiros e exiba a quantidade de valores positivos,
negativos e zeros.
*/


public class Ex6 implements Exercise {

    private static final int ARRAY_SIZE = 10;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 6 ---\n");

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
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Positivos: " + NumberUtils.countPositive(array));
        System.out.println("Negativos: " + NumberUtils.countNegative(array));
        System.out.println("Zeros: " + NumberUtils.countZero(array));

    }
}
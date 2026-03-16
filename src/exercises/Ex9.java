package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;
import utils.NumberUtils;

/* 
Leia um vetor de 10 inteiros e um número K. Multiplique todos os elementos
por K e exiba o vetor resultante.
*/


public class Ex9 implements Exercise {

    private static final int ARRAY_SIZE = 10;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 9 ---\n");

        Integer[] array = new Integer[ARRAY_SIZE];
        int num_k = 0;

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
                System.out.println("Digite um número K inteiro.");
                System.out.print("||");
                num_k = sc.nextInt();
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

    
        ConsoleUtils.clear();
        System.out.println("Array Original: " + Arrays.toString(array));
        System.out.println("Array * " + num_k + ":" + NumberUtils.multiplyByScalar(array, num_k));
    }
}
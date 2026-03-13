package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;
import utils.NumberUtils;

/* 
Crie um programa que leia um vetor de 10 números inteiros e verifique quais
números são primos. Exiba os números primos encontrados.
*/

public class Ex3 implements Exercise {

    private static final int ARRAY_SIZE = 10;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 3 ---\n");

        Integer[] array = new Integer[ARRAY_SIZE];

        int last_int = 0;
        while (last_int < ARRAY_SIZE) {
            try{

                for(int i=last_int; i< ARRAY_SIZE; i++){
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

        Integer[] list_primes = Arrays.stream(array)
                    .filter(x -> NumberUtils.isPrime(x))
                    .toArray(x -> new Integer[x]);

        ConsoleUtils.clear();
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Primos: " + Arrays.toString(list_primes));

    }
}
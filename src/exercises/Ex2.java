package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.StatisticsUtils;
import utils.ConsoleUtils;
import utils.NumberUtils;

/* 
Crie um programa que solicite ao usuário a entrada de 20 números inteiros,
armazenando-os em um vetor. Em seguida, o programa deve calcular e
exibir:
    *Maior valor.
    *Menor valor.
    *Média dos valores.
    *Moda dos valores (o número que mais se repete).
    *Quantidade de números pares.
    *Quantidade de números ímpares.
    *Desvio padrão dos valores.
*/

public class Ex2 implements Exercise {

    private static final int ARRAY_SIZE = 20;

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 2 ---\n");

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
        System.out.println("Maior valor: " + StatisticsUtils.max(array));
        System.out.println("Menor valor: " + StatisticsUtils.min(array));
        System.out.printf("Média: %.2f%n", StatisticsUtils.mean(array));
        System.out.println("Moda: " + StatisticsUtils.mode(array));
        System.out.println("Quantidade de pares: " + NumberUtils.countEven(array));
        System.out.println("Quantidade de ímpares: " + NumberUtils.countOdd(array));
        System.out.printf("Desvio padrão: %.2f%n", StatisticsUtils.standardDeviation(array));
    }
}
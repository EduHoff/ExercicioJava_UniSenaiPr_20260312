package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.ConsoleUtils;

/* 
Crie um programa que leia um vetor de 10 números inteiros. Em seguida,
solicite ao usuário dois valores, A e B, que definem um intervalo. O programa
deve contar e exibir quantos elementos do vetor estão dentro do intervalo
[A, B](incluindo os limites). Caso o usuário informe A > B, o programa deve
ajustar o intervalo (trocar os valores) antes de realizar a contagem.
*/


public class Ex11 implements Exercise {

    private static final int ARRAY_SIZE = 10;
    
    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 11 ---\n");

        Integer[] array = new Integer[ARRAY_SIZE];
        int min_A = 0;
        int max_B = 0;

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
                System.out.println("Digite um número A inteiro.");
                System.out.print("||");
                min_A = sc.nextInt();
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

        while (true) {
            try{
                System.out.println("Digite um número B inteiro.");
                System.out.print("||");
                max_B = sc.nextInt();
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

        if(min_A > max_B){
            int aux = min_A;
            max_B = min_A;
            min_A = aux;
        }

        int count = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] >= min_A && array[i] <= max_B){
                count++;
            }
        }

    
        ConsoleUtils.clear();
        System.out.println("Array Original: " + Arrays.toString(array));
        System.out.println("No o intervalo de " + min_A + " até " + max_B + " há um total de " + count + " elementos!");
    }
}
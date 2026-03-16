package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.CollectionUtils;
import utils.ConsoleUtils;
import utils.NumberUtils;

/* 
Leia um vetor de N inteiros e verifique se ele é um palíndromo (lê igual da
esquerda para a direita e vice-versa). Exiba “SIM” ou “NÃO”.
*/

public class Ex10 implements Exercise {
    

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 10 ---\n");

        Integer[] array = null;
        int array_size = 0;

        while (true) {
            try{
                System.out.println("Digite o tamnho do array.");
                System.out.print("||");
                array_size = sc.nextInt();

                if(array_size <= 0){
                    throw new IllegalArgumentException("Variable cannot be zero or negative");
                }

                array = new Integer[array_size];
                ConsoleUtils.clear();
                break;

            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch(IllegalArgumentException e){
                ConsoleUtils.clear();
                System.out.println("Digite um número maior que zero!\n");
                sc.nextLine();
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            }
        }

        int last_int = 0;
        while (last_int < array_size) {
            try{

                for(int i=last_int; i<array_size; i++){
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
        System.out.println("Array Invertido: " + Arrays.toString(CollectionUtils.invertList(array)));
        System.out.print("Palíndromo: ");
        if(NumberUtils.isPalindrome(array)){
            System.out.println("SIM");
        }else{
            System.out.println("NÃO");
        } 
    }
}
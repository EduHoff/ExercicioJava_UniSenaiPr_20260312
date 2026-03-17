package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.CollectionUtils;
import utils.ConsoleUtils;

/* 
Leia 10 inteiros. Depois leia uma posição P (0 a 9) e remova esse elemento
deslocando os seguintes para a esquerda. Exiba os 9 restantes.
*/


public class Ex12 implements Exercise {

    private static final int ARRAY_SIZE = 10;
    
    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 12 ---\n");

        Integer[] array = new Integer[ARRAY_SIZE];
        int index_p = 0;

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
                System.out.println("Digite um número P inteiro no intervalo de 0 até " + (ARRAY_SIZE - 1) + ".");
                System.out.print("||");
                index_p = sc.nextInt();
                if(index_p < 0 || index_p >= ARRAY_SIZE){
                    throw new IndexOutOfBoundsException();
                }
                break;
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch(IndexOutOfBoundsException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números no intervalo de 0 até " + (ARRAY_SIZE - 1) + ".\n");
                index_p=0;
                sc.nextLine();
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            }
        }

    
        ConsoleUtils.clear();
        System.out.println("Array Original: " + Arrays.toString(array));
        System.out.println("Array sem o index " + index_p + ": " + CollectionUtils.removeItemList(array, index_p));
    }
}
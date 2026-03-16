package exercises;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.CollectionUtils;
import utils.ConsoleUtils;

/* 
Analise o código abaixo e faça o teste de mesa, indicando ao final qual será
a saída do programa.
*/

//OBS.: use o debugger caso queira fazer o teste de mesa

public class Ex5 implements Exercise {
    

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 5 ---\n");

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
        System.out.println("Array Original: " + Arrays.toString(array));
        System.out.println("Array Invertido: " + Arrays.toString(CollectionUtils.invertList(array)));
    }
}
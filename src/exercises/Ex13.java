package exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import exceptions.DuplicateValueException;
import utils.ConsoleUtils;
import utils.NumberUtils;

/* 
Neste exercício, você vai criar um programa que simula um jogo de loteria. O
programa deve começar gerando 6 números aleatórios, cada um entre 1 e
60, que representam o bilhete sorteado. Em seguida, o programa deve pedir
ao usuário que digite 6 números (também entre 1 e 60), que representam o
bilhete escolhido pelo jogador. Após o usuário digitar os números, o
programa deve comparar os números escolhidos pelo usuário com os
números sorteados aleatoriamente e informar quantos números coincidem
entre os dois bilhetes. Por exemplo, se os números sorteados forem [5, 12,
23, 34, 45, 56] e o usuário digitar [12, 23, 34, 55, 57, 58], o programa deve
informar que o usuário acertou 3 números (12, 23 e 34) (Pesquise como gerar
números aleatórios no java).
*/


public class Ex13 implements Exercise {

    private static final int ARRAY_SIZE = 6;
    
    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 13 ---\n");

        Integer[] array = new Integer[ARRAY_SIZE];

        Set<Integer> aux_lucky_numbers = new HashSet<>();
        while (aux_lucky_numbers.size() < ARRAY_SIZE) {
            aux_lucky_numbers.add(NumberUtils.generateRandomNumber(1, 60));
        }

        Integer[] lucky_numbers = aux_lucky_numbers.toArray(new Integer[ARRAY_SIZE]);
        
        int last_int = 0;
        Set<Integer> aux_array = new HashSet<>();
        while (last_int < ARRAY_SIZE) {
            try{

                
                for(int i=last_int; i<ARRAY_SIZE; i++){
                    System.out.println("Digite o "+(i+1)+"º número inteiro.");
                    System.out.print("||");
                    int num = sc.nextInt();

                    if(num < 1 || num > 60){
                        throw new IndexOutOfBoundsException();
                    }

                    if(aux_array.contains(num)){
                        throw new DuplicateValueException("Values cannot be duplicated");
                    }else{
                        aux_array.add(num);
                    }

                    array[i] = num;
                    last_int = i + 1;
                    ConsoleUtils.clear();
                }
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
             }catch(IndexOutOfBoundsException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números no intervalo de 1 até 60!\n");
                sc.nextLine();
            }catch(DuplicateValueException e){
                ConsoleUtils.clear();
                System.out.println("Esse número já foi digitado antes!\n");
                sc.nextLine();
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            }
        }

        int correct = 0;
        int coincidence = 0;
        for(int i=0; i<ARRAY_SIZE; i++){
            if(array[i].equals(lucky_numbers[i])){ //verfica se o usuário acertou o número na posição certa
                correct++;
                coincidence++;
            }else{
                for(int j=0; j<ARRAY_SIZE; j++){
                    if(array[i].equals(lucky_numbers[j])){ //verfica se o número do usuário aparece em alguma outra posição
                        coincidence++;
                        break;
                    }
                }
            }
        }

    
        ConsoleUtils.clear();
        System.out.println("Números sorteados: " + Arrays.toString(lucky_numbers));
        System.out.println("Números escolhidos: " + Arrays.toString(array));
        System.out.println("Total de acertos: " + correct);
        System.out.println("Total de coincidências: " + coincidence);

        if(correct == 6){
            System.out.println("\nOk. Eu estou com medo da sua sorte...");
        }
    }
}
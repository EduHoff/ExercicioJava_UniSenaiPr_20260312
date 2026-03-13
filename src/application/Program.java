package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import exercises.Exercise;
import utils.ConsoleUtils;



public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ConsoleUtils.clear();
        while (true) {
            try{

                System.out.print("""
                ============================================
                            MENU DE EXERCÍCIOS
                ============================================
                1 - Teste de Mesa
                2 - Análise Estatística de Vetor
                3 - Identificação de Números Primos
                4 - Remoção de Valores Duplicados
                5 - Inversão de Vetor
                6 - Contagem de Positivos, Negativos e Zeros
                7 - Busca de Número no Vetor
                8 - Verificação de Ordem Crescente
                9 - Multiplicação de Vetor por Escalar
                10 - Verificação de Palíndromo
                11 - Contagem em Intervalo
                12 - Remoção de Elemento por Posição
                13 - Simulador de Loteria
                0 - Sair
                ===========================================
                """);

                System.out.print("||");
                int num = sc.nextInt();

                if (num == 0) {
                    break;
                }

                Class<?> clazz = Class.forName("exercises.Ex" + num);
                Exercise ex = (Exercise) clazz.getDeclaredConstructor().newInstance();
                ConsoleUtils.clear();
                ex.run(sc);

            
            }catch(InputMismatchException e){
                ConsoleUtils.clear();
                System.out.println("Digite apenas números inteiros!\n");
                sc.nextLine();
            }catch (ClassNotFoundException e) {
                ConsoleUtils.clear();
                System.out.println("Exercício não existe!\n");
            }catch(Exception e){
                ConsoleUtils.clear();
                e.printStackTrace();
            } 
        }

        sc.close();
    }
}
package exercises;

import java.util.Scanner;

/* 
Analise o código abaixo e faça o teste de mesa, indicando ao final qual será
a saída do programa.
*/

//OBS.: use o debugger caso queira fazer o teste de mesa

public class Ex1 implements Exercise {

    @Override
    public void run(Scanner sc) {
        System.out.println("--- Exercício 1 ---\n");

        int[] a = {4,7,2,9,5};
        int b = 0;
        int c = a[0];
        int d = 0;

        for (int i=0; i < a.length; i++) {
            b = b + a[i];

            if(a[i] > c){
                c = a[i];
                d = i;
            }
        }

        System.out.println(b); //27
        System.out.println(c); //9
        System.out.println(d); //3
    }
}
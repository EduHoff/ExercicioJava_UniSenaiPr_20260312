package exercises;

import utils.ArrayUtils;

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

    @Override
    public void run() {
        System.out.println("--- Exercício 2 ---\n");

        Integer[] lsita1 = {1,2,3,4,5,6,7,7,7,6,6};
        Double[] lista2 = {1.2, 1.5, 0.0, -2.5, 10.0, 7.7};
        //String[] lista3= {"a", "b", "c", "e", "d"};


        System.out.println("Lista 1: " + ArrayUtils.mode(lsita1));
        System.out.println("Lista 2: " + ArrayUtils.mode(lista2));
        //System.out.println("Lista 3: " + ArrayUtils.min(lista3));

    }
}
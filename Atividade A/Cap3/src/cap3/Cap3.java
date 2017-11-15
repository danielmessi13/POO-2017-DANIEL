/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap3;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */

// SETIMA E OITAVA PRECISAM INSERIR VALORES...
public class Cap3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Exercicios: variaveis e tipos primitivos
        
        int gastosJaneiro = 15000;
        int gastosFevereiro = 23000;
        int gastosMarco = 17000;
        int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
        double mediaMensal = gastosTrimestre / 3.0;
        
        System.out.println(gastosTrimestre);
        String resultado = String.format("%.2f", mediaMensal);
        System.out.println("Valor da média mensal = " + resultado + "\n");
        
        // Exercicio: fixação de sintaxe.
        // 1) Imprimir de 150 a 300.
        int cont = 0;
        for (int i = 150; i <= 300; i++){
            cont++;
            if (i == 300 || cont == 30){
                System.out.println(i + "\n");
                cont = 0;
            } else {
                System.out.print(i + ",");
            }
        }
        
        // 2) Soma de 1 até 1000;
        int n1 = 1, n2 = 1000, soma;
        soma = (n1 + n2) * n2 / 2;
        System.out.println("Soma = " + soma + "\n");
        
        // 3) Multiplos de 3 entre 1 e 100;
        String mult = "";
        for (int i = 1; i <= 100; i++){
            if (i == 100){
                mult += "\n";
            }
            if (i % 3 == 0){
                mult += i + " ";
            }
        }
        System.out.println("Multiplos = " + mult);
        
        // 4) Fatorial 1 a 10;
        long fatorial = 1;
        for (int i = 1 ; i <= 10; i++){
            fatorial = fatorial * i;
            System.out.println("Fatorial de " + i + " = " + fatorial);
        }
        System.out.print("\n");
        
        // 6) Fibonacci até 100;
        int aux;
        int num1 = 0;
        int num2 = 1;
        System.out.print("Fibo = ");
        for (int i = 0; i <= 50; i++){
            if (num1 > 100){
                System.out.print(num1);
                break;
            }
            System.out.print(num1 + ", ");
            aux = num1 + num2;
            num1 = num2;
            num2 = aux;
            
        }
        System.out.print("\n");
        
        // 7) Pegar um valor X e fazer umas operações com ele;
        Scanner entrada = new Scanner(System.in);
        int numero = entrada.nextInt();
        for (int i = numero; i >= 1; i--){
            if (numero % 2 == 0){
                numero = numero / 2;
            } else {
                numero = 3 * numero + 1;
            }
            if (numero == 1){
                System.out.print(" -> " + numero + "\n");
                break;
            } else{
                System.out.print(" -> " + numero);
            }    
        }
        
        // 8) Imprimir uma tabela com fors
        int inicial = 1;
        int max = entrada.nextInt();
        
        for (int i = 1; i <= max; i++){
            System.out.print(inicial + " ");
            for (int j = 2; j <= i; j++){
                System.out.print(inicial * j + " ");                
            }
            System.out.print("\n");
            inicial++;
        }
        
        // Fibonacci com duas variaveis
        
        int tamanho = entrada.nextInt();
        int number1 = 0, number2 = 1;
         System.out.print("Fibo = ");
        for (int i = 0; i <= tamanho; i++){
            number2 = number2 + number1;
            number1 =  number2 - number1;
            System.out.print(number2 + " ");
        }
        System.out.print("\n");
    }  
}
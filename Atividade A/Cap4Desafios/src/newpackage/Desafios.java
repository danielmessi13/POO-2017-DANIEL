/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Daniel
 */
public class Desafios {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 1; i <= 6; i++){
            int resultado = fibonacci.calculaFibonacci(i);
            System.out.print(resultado + " ");
        }
        System.out.print("\n");
    }
}

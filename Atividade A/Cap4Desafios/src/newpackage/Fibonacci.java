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
public class Fibonacci {
    
int calculaFibonacci(int i){
    // return (i > 2) ? 1 : calculaFibonacci(i - 1) + calculaFibonacci(i - 2);
    if (i > 2){
        return calculaFibonacci(i - 1) + calculaFibonacci(i - 2);
    } else{
        return 1;
    }
}
}

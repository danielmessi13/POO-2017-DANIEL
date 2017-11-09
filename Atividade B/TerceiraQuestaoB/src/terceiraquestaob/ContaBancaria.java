/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terceiraquestaob;

/**
 *
 * @author aluno
 */
public class ContaBancaria {
    int numero;
    int saldo;
    Titular pessoa = new Titular();
    
void depositar(int valor){
    this.saldo += valor;
}

void sacar(int valor){
    if(this.saldo >= valor){
        this.saldo -= valor;
    }
    
}

}





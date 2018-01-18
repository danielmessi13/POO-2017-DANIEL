/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Conta {
    double saldo;
    double limite;

    public void deposita(double valor){
        this.saldo += valor;
    }
    
    public void saca(double valor){
        if (this.saldo < valor && valor > limite){
            this.saldo -= valor;
            throw new SaldoInsuficienteException("Saldo Insuficiente, "
                    + "tente um valor menor");
        }else{
            this.saldo -= valor;
        }  
    }

    public double getSaldo() {
        return saldo;
    }
    
    
}

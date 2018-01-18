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
        if (valor < 0){
            throw new IllegalArgumentException("Impossivel depositar valor negativo");
        }else{
            this.saldo += valor;
        }
        
    }
    
    public void saca(double valor) throws SaldoInsuficienteException{
        if (valor < 0){
            throw new IllegalArgumentException("Valores " + 
                        "negativos nao sao validos");
        }
        if (this.saldo < valor && valor > limite){
            throw new SaldoInsuficienteException(valor);
        }else{
            this.saldo -= valor;
        }  
    }

    public double getSaldo() {
        return saldo;
    }
    
    
}

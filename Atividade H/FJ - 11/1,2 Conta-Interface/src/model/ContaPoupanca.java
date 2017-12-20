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
public class ContaPoupanca implements Conta{
    private double saldo;

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void deposita(double valor) {
        this.saldo += valor;
    }

    @Override
    public void saca(double valor) {
        if (valor >= this.saldo){
            this.saldo -= valor;
        }
        
    }   

    @Override
    public void atualiza(double taxaSelic) {
        this.saldo += saldo * taxaSelic;
    }
    
}

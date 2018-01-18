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
    String nome;
    double saldo;
    
    public int sacar(double valor){
        if (valor >= this.saldo){
            this.saldo -= valor;
            return 1;
        }
        
        return 0;
    }
    
    public void deposita(double valor){
        this.saldo += valor;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}

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
public class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException(double valor) {
        super("Saldo insuficiente para sacar o valor de:" + valor);
    }

}

package app;

import model.Conta;
import model.SaldoInsuficienteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class TesteErro {
    
    public static void main(String[] args) {
        Conta conta = new Conta();
        try {
            //conta.deposita(-10);
            conta.saca(10);
        } catch (SaldoInsuficienteException ex) {
            
        }
    }
    
}

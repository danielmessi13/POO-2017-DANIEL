/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.*;

/**
 *
 * @author aluno
 */
public class TestaBanco {
    public static void main(String[] args) {
        Banco banco = new Banco("Daniel Society", 10);

        //Conta conta = new Conta();
        Conta contaCorrente = new ContaCorrente();
        Conta contaPoupanca = new ContaPoupanca();

        //conta.deposita(1000);
        contaCorrente.deposita(1000);
        contaPoupanca.deposita(1000);

        //banco.adiciona(conta);
        banco.adiciona(contaCorrente);
        banco.adiciona(contaPoupanca);

        AtualizadorDeContas atualizador = new AtualizadorDeContas(0.01);

        for (int i = 0; i < banco.getTotalDeContas(); i++) {
                atualizador.roda(banco.pegaConta(i));
        }

        System.out.println(banco.mostraContas() + "Saldo banco: "
        + atualizador.getSaldoTotal());
        
    }
}


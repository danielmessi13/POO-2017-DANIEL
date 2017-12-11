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
public class AtualizadorDeContas {
    private double saldoTotal;
    private double selic;

    public AtualizadorDeContas(double selic) {
        this.selic = selic;
    }

    public String roda(Conta conta) {
        String relatorio = "Saldo anterior " + conta.getSaldo();
        conta.atualiza(this.selic);
        relatorio += "Saldo final: " + conta.getSaldo();
        this.saldoTotal += conta.getSaldo();
        return relatorio;
    }

    public double getSaldoTotal() {
        return this.saldoTotal;
    }
}

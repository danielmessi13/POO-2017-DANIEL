package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class ContaCorrente extends Conta{
    @Override
    public void saca(double valor) throws SaldoInsuficienteException{
            if (valor < 0){
                throw new IllegalArgumentException("Valores " + 
                            "negativos nao sao validos");
            }
            if (this.saldo < valor && valor > limite){
                throw new SaldoInsuficienteException(valor);
            }else{
                this.saldo -= (valor + 0.10);
            }  
        }
}
